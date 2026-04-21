/*
 * Problem: 1875. Group Employees of the Same Salary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/group-employees-of-the-same-salary/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
with a as (select employee_id, COUNT(*) over (partition by salary) as cnt
from Employees),
b as (select employee_id
from a
where cnt>1)
select *, DENSE_RANK() over (order by salary) as team_id
from Employees
where employee_id in (select employee_id from b)
order by team_id, employee_id
