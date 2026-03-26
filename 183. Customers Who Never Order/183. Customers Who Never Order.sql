/*
 * Problem: 183. Customers Who Never Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/customers-who-never-order/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select a.name as Customers
from Customers as a
left join Orders as b
on a.id=b.customerId
where b.id is null
