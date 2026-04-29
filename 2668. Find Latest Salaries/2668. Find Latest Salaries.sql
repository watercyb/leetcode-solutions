/*
 * Problem: 2668. Find Latest Salaries
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-latest-salaries/
 * Language: mysql
 * Date: 2026-04-29
 */

# Write your MySQL query statement below
select emp_id, firstname, lastname, MAX(salary) as salary, department_id
from Salary
group by emp_id
order by emp_id
