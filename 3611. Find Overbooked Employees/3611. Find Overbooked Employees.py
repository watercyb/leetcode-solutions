#
# Problem: 3611. Find Overbooked Employees
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-overbooked-employees/
# Language: python3
# Date: 2026-05-09


# Write your MySQL query statement below
with id as (
    select employee_id
    from meetings
    group by employee_id, week(meeting_date, 1), year(meeting_date)
    having SUM(duration_hours)>20
),
sm as (
    select employee_id, COUNT(*) as meeting_heavy_weeks
    from id
    group by employee_id
    having meeting_heavy_weeks>=2
)
select a.*, b.meeting_heavy_weeks
from employees as a, sm as b
where a.employee_id=b.employee_id
order by meeting_heavy_weeks desc, employee_name
