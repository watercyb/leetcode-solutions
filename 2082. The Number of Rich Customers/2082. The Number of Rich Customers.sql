/*
 * Problem: 2082. The Number of Rich Customers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-number-of-rich-customers/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
select COUNT(distinct customer_id) as rich_count
from Store
where amount>500
