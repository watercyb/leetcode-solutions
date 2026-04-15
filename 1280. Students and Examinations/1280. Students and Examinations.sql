/*
 * Problem: 1280. Students and Examinations
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/students-and-examinations/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select a.student_id, a.student_name, a.subject_name, COUNT(b.student_id) as attended_exams
from
(select a.student_id, a.student_name, b.subject_name
from Students as a, Subjects as b) as a
left join Examinations as b
on a.student_id=b.student_id and a.subject_name=b.subject_name
group by student_id,student_name,subject_name
order by student_id, subject_name
