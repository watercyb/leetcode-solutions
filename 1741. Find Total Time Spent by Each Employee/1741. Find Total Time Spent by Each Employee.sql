/*
 * Problem: 1741. Find Total Time Spent by Each Employee
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-total-time-spent-by-each-employee/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select event_day as day, emp_id, SUM(out_time-in_time) as total_time
from Employees
group by event_day, emp_id
