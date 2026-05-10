/*
 * Problem: 3764. Most Common Course Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/most-common-course-pairs/
 * Language: mysql
 * Date: 2026-05-10
 */

# Write your MySQL query statement below
with list as (
    select user_id, COUNT(*) as cnt, AVG(course_rating) as avge
    from course_completions
        group by user_id
having cnt>=5 and avge>=4
),
t1 as (
    select *, row_number() over (partition by user_id order by completion_date) as rnk
    from course_completions
    where user_id in (select user_id from list)
),
merge as (
    select a.course_name as first_course, b.course_name as second_course
    from t1 as a, t1 as b
    where a.user_id=b.user_id and a.rnk+1=b.rnk
)
select *, COUNT(*) as transition_count
from merge
group by first_course, second_course
order by transition_count desc, first_course, second_course
