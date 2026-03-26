/*
 * Problem: 185. Department Top Three Salaries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/department-top-three-salaries/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select a.name as Department, b.name as Employee, b.salary
from Department as a,
(select distinct departmentId,name, salary, dense_rank() over (partition by departmentId order by salary desc) as r
from Employee
order by departmentId, salary desc) as b
where a.id=b.departmentId and b.r<=3
