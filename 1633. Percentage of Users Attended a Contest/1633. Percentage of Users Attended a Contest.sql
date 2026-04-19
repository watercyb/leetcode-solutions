/*
 * Problem: 1633. Percentage of Users Attended a Contest
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/percentage-of-users-attended-a-contest/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select contest_id,ROUND(COUNT(user_id)/(select COUNT(*) from Users)*100,2) as percentage
from Register
group by contest_id
order by percentage desc,contest_id
