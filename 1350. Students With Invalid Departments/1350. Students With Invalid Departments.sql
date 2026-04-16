/*
 * Problem: 1350. Students With Invalid Departments
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/students-with-invalid-departments/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select id, name
from Students
where department_id not in (select id from Departments)
