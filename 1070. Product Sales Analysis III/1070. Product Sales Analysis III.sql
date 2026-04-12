/*
 * Problem: 1070. Product Sales Analysis III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/product-sales-analysis-iii/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select product_id, year as first_year, quantity, price
from Sales
where (product_id, year) in (select product_id,MIN(year) from Sales group by product_id)
