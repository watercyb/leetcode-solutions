/*
 * Problem: 1068. Product Sales Analysis I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/product-sales-analysis-i/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select b.product_name, a.year, a.price
from Sales as a, Product as b
where a.product_id=b.product_id
