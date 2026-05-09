/*
 * Problem: 3617. Find Students with Study Spiral Pattern
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-students-with-study-spiral-pattern/
 * Language: mysql
 * Date: 2026-05-09
 */

# Write your MySQL query statement below
with prv as (
    select student_id, session_date, LAG(session_date) over (partition by student_id order by session_date) as prv
    from study_sessions
),
lim1 as (
    select distinct student_id
    from prv
    where prv is not null and DATEDIFF(session_date, prv)>2
),
t1 as (
    select *
    from study_sessions
    where student_id not in (select student_id from lim1)
),
cnt as (
    select student_id, subject, COUNT(*) as cnt
    from t1
    group by student_id, subject
),
lim2 as (
    select distinct a.student_id
    from cnt as a, cnt as b
    where (a.student_id=b.student_id and a.cnt!=b.cnt) or a.cnt<2
),
t2 as (
    select *
    from t1
    where student_id not in (select student_id from lim2)
),
sm as (
    select student_id, subject, SUM(hours_studied) as sm
    from t2
    group by student_id, subject
),
grp as (
    select student_id, COUNT(subject) as cycle_length, SUM(sm) as total_study_hours
    from sm
    group by student_id
    having cycle_length>2
)
select b.*, a.cycle_length, a.total_study_hours
from grp as a, students as b
where a.student_id=b.student_id
order by cycle_length desc, total_study_hours desc
