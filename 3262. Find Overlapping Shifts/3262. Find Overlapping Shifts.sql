/*
 * Problem: 3262. Find Overlapping Shifts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-overlapping-shifts/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-03-25
 */

# Write your MySQL query statement below
with un as (
    select employee_id, start_time as t, 1 as n
    from EmployeeShifts
    union all
    select employee_id, end_time as t, -1 as n
    from EmployeeShifts
),
sm as (
    select employee_id, SUM(n) over (partition by employee_id order by t) as sm, n
    from un
)
select employee_id, SUM(sm)-COUNT(sm) as overlapping_shifts
from sm
where n=1
group by employee_id
having overlapping_shifts>0
