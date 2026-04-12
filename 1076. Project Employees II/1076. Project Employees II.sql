/*
 * Problem: 1076. Project Employees II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/project-employees-ii/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select project_id
from Project
group by project_id
having COUNT(*)=
(select COUNT(*) as count
from Project
group by project_id
order by count desc
limit 1)
