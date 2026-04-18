/*
 * Problem: 1549. The Most Recent Orders for Each Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-most-recent-orders-for-each-product/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select a.product_name, a.product_id, b.order_id, b.order_date
from
Products as a,
(select *
from
(select order_id, order_date, product_id, RANK() over (partition by product_id order by order_date desc) as r
from Orders) as a
where r=1) as b
where a.product_id=b.product_id
order by product_name, product_id, order_id
