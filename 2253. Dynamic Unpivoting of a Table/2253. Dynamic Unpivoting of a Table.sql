/*
 * Problem: 2253. Dynamic Unpivoting of a Table
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/dynamic-unpivoting-of-a-table/
 * Language: mysql
 * Date: 2026-04-25
 */

CREATE PROCEDURE UnpivotProducts()
BEGIN
	# Write your MySQL query statement below.
    set session group_concat_max_len = 1000000;
    SET @Expression = 'SELECT * from Products';
    SELECT GROUP_CONCAT(
            CONCAT('select product_id, "', COLUMN_NAME, '" as store, ', COLUMN_NAME, ' as price from Products having price is not null ') separator 'union all '
        )
    FROM INFORMATION_SCHEMA.COLUMNS
    WHERE table_name = 'Products' and COLUMN_NAME!='product_id'
    into @Expression;
    PREPARE myquery FROM @Expression;
    EXECUTE myquery;
END
