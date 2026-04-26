/*
 * Problem: 2324. Product Sales Analysis IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/product-sales-analysis-iv/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with r as (select a.product_id, a.user_id,RANK() over (partition by a.user_id order by SUM(a.quantity*b.price) desc) as r
from Sales as a, Product as b
where a.product_id=b.product_id
group by a.product_id, a.user_id)
select user_id, product_id
from r
where r=1
