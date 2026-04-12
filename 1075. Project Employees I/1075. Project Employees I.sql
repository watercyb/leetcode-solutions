/*
 * Problem: 1075. Project Employees I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/project-employees-i/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select a.project_id, ROUND(AVG(b.experience_years),2) as average_years
from Project as a, Employee as b
where a.employee_id=b.employee_id
group by a.project_id
