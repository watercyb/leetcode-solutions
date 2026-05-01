/*
 * Problem: 2893. Calculate Orders Within Each Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/calculate-orders-within-each-interval/
 * Language: mysql
 * Date: 2026-05-01
 */

# Write your MySQL query statement below
select FLOOR((minute-1)/6)+1 as interval_no, SUM(order_count) as total_orders
from Orders
group by interval_no
order by interval_no
