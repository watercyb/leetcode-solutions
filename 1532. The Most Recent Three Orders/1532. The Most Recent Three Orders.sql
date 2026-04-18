/*
 * Problem: 1532. The Most Recent Three Orders
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-most-recent-three-orders/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
with a as (select order_id, order_date, customer_id, rank() over (partition by customer_id order by order_date desc) as r
from Orders)
select b.name as customer_name, b.customer_id, a.order_id, a.order_date
from a, Customers as b
where a.customer_id=b.customer_id and a.r<=3
order by name, customer_id, order_date desc
