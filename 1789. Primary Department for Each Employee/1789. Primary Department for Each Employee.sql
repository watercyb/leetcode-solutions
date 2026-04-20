/*
 * Problem: 1789. Primary Department for Each Employee
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/primary-department-for-each-employee/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select employee_id, department_id
from employee
where primary_flag='Y'
union
select employee_id, department_id
from employee
group by employee_id
having COUNT(department_id)=1
