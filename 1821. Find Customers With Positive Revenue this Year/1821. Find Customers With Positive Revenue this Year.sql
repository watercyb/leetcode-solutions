/*
 * Problem: 1821. Find Customers With Positive Revenue this Year
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-customers-with-positive-revenue-this-year/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select customer_id
from Customers
where year='2021'
group by customer_id
having SUM(revenue)>0
