/*
 * Problem: 184. Department Highest Salary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/department-highest-salary/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select a.name as Department, b.name as Employee, b.salary
from Department as a,
(select name,salary,departmentId, rank() over (partition by departmentId order by salary desc) as r
from Employee) as b
where a.id=b.departmentId and b.r=1
