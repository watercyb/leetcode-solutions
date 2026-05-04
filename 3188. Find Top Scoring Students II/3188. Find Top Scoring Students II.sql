/*
 * Problem: 3188. Find Top Scoring Students II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-top-scoring-students-ii/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with overall as (select a.*, b.major as studentMajor, c.credits, c.major as courseMajor, c.mandatory
from enrollments as a, students as b, courses as c
where a.student_id=b.student_id and a.course_id=c.course_id),
mandatoryCourses as (select major, COUNT(*) as mCount
from courses
where mandatory='yes'
group by major),
require13 as (select student_id, studentMajor,
SUM(case when studentMajor=courseMajor and mandatory='yes' then 1 else 0 end) as mCount,
SUM(case when studentMajor=courseMajor and mandatory='no' then 1 else 0 end) as eCount, AVG(GPA) as GPA
from overall
group by student_id
having (studentMajor,mCount) in (select major, mCount from mandatoryCourses) and eCount>=2 and GPA>=2.5),
require2 as (select distinct student_id
from overall
where (studentMajor=courseMajor and mandatory='yes' and grade!='A')||(grade!='A'&&grade!='B'))
select student_id
from students
where student_id in (select student_id from require13) and student_id not in (select student_id from require2)
order by student_id
