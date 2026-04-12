/*
 * Problem: 1077. Project Employees III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/project-employees-iii/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select project_id, employee_id
from
(select a.project_id, a.employee_id, RANK() over (partition by a.project_id order by b.experience_years desc) as r
from Project as a, Employee as b
where a.employee_id=b.employee_id) as a
where r=1
