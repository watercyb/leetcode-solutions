/*
 * Problem: 2084. Drop Type 1 Orders for Customers With Type 0 Orders
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/drop-type-1-orders-for-customers-with-type-0-orders/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
select *
from Orders
where order_type=0 or customer_id not in 
(select customer_id
from Orders
where order_type=0
group by customer_id)
