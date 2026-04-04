/*
 * Problem: 586. Customer Placing the Largest Number of Orders
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select customer_number
from Orders
group by customer_number
order by COUNT(order_number) desc
limit 1
