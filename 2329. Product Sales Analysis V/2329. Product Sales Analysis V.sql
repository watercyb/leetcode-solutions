/*
 * Problem: 2329. Product Sales Analysis V
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/product-sales-analysis-v/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
select a.user_id, SUM(a.quantity*b.price) as spending
from Sales as a, Product as b
where a.product_id=b.product_id
group by a.user_id
order by spending desc, user_id
