/*
 * Problem: 1565. Unique Orders and Customers Per Month
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/unique-orders-and-customers-per-month/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select DATE_FORMAT(order_date, "%Y-%m") as month, COUNT(*) as order_count, COUNT(distinct(customer_id)) as customer_count
from Orders
where invoice>20
group by month
