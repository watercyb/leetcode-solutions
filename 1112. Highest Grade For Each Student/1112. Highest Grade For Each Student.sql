/*
 * Problem: 1112. Highest Grade For Each Student
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/highest-grade-for-each-student/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select student_id, course_id, grade
from
(select *, ROW_NUMBER() over (partition by student_id order by grade desc, course_id) as r
from Enrollments) as a
where r=1
