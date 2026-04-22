/*
 * Problem: 1965. Employees With Missing Information
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/employees-with-missing-information/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
select employee_id
from Employees
where employee_id not in (select employee_id from Salaries)
union all
select employee_id
from Salaries
where employee_id not in (select employee_id from Employees)
order by employee_id
