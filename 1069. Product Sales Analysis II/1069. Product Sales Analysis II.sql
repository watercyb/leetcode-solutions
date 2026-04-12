/*
 * Problem: 1069. Product Sales Analysis II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/product-sales-analysis-ii/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select product_id, SUM(quantity) as total_quantity
from Sales
group by product_id
