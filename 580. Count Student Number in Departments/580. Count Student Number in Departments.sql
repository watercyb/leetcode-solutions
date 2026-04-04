/*
 * Problem: 580. Count Student Number in Departments
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-student-number-in-departments/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select a.dept_name, COUNT(b.student_id) as student_number
from Department as a
left join Student as b
on a.dept_id=b.dept_id
group by dept_name
order by student_number desc, dept_name
