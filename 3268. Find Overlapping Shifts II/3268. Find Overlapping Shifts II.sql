/*
 * Problem: 3268. Find Overlapping Shifts II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-overlapping-shifts-ii/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
with r as (select *, ROW_NUMBER() over (partition by employee_id order by start_time) as r
from EmployeeShifts),
combined as (select a.employee_id, b.start_time, LEAST(a.end_time, b.end_time) as end_time, b.r-a.r as r
from r as a
left join r as b
on a.employee_id=b.employee_id and a.r<b.r and a.end_time>b.start_time)
select employee_id, IFNULL(MAX(r),0)+1 as max_overlapping_shifts, IFNULL(SUM(TIMESTAMPDIFF(minute,start_time,end_time)),0) as total_overlap_duration
from combined
group by employee_id
