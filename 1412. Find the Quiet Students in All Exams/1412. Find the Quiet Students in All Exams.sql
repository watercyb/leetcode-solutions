/*
 * Problem: 1412. Find the Quiet Students in All Exams
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-quiet-students-in-all-exams/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
with a as (select exam_id, MAX(score) as maxScore, MIN(score) as minScore
from Exam
group by exam_id),
b as (select distinct student_id
from Exam
where (exam_id, score) in (select exam_id, maxScore from a) or (exam_id, score) in (select exam_id, minScore from a))
select *
from Student
where student_id in (select student_id from Exam) and student_id not in (select student_id from b)
