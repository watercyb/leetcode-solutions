/*
 * Problem: 2346. Compute the Rank as a Percentage
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/compute-the-rank-as-a-percentage/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with cnt as (
    select department_id, COUNT(*)-1 as cnt
    from Students
    group by department_id
),
r as (
    select student_id, department_id, RANK() over (partition by department_id order by mark desc)-1 as r
    from Students
)
select a.student_id, a.department_id, IFNULL(ROUND(a.r/b.cnt*100,2),0) as percentage
from r as a, cnt as b
where a.department_id=b.department_id
