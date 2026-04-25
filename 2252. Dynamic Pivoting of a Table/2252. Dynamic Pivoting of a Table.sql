/*
 * Problem: 2252. Dynamic Pivoting of a Table
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/dynamic-pivoting-of-a-table/
 * Language: mysql
 * Date: 2026-04-25
 */

CREATE PROCEDURE PivotProducts()
BEGIN
	# Write your MySQL query statement below.
    set session group_concat_max_len = 1000000;
    set @script='select product_id, ';
    set @script=CONCAT(@script, 
        (select GROUP_CONCAT(distinct CONCAT('SUM(case when store="', store, '" then price else null end) as ', store)) from Products));
    set @script=CONCAT(@script,' from Products group by product_id');
    prepare stmt from @script;
	execute stmt;
	deallocate prepare stmt;
END
