/*
 * Problem: 3182. Find Top Scoring Students
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-top-scoring-students/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with cnt1 as (
    select a.student_id, a.major, COUNT(*) as cnt
    from students as a, courses as b, enrollments as c
    where a.student_id=c.student_id and c.grade='A' and c.course_id=b.course_id and a.major=b.major
    group by a.student_id
),
cnt2 as (
    select major, COUNT(*) as cnt
    from courses
    group by major
)
select a.student_id
from cnt1 as a, cnt2 as b
where a.major=b.major and a.cnt=b.cnt
order by student_id
