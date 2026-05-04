/*
 * Problem: 3156. Employee Task Duration and Concurrent Tasks
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/employee-task-duration-and-concurrent-tasks/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with total as (select task_id, employee_id, start_time as t, 1 as n
from Tasks
union all
select task_id, employee_id, end_time, -1 as n
from Tasks),
s as (select employee_id, n, SUM(n) over (partition by employee_id order by t, task_id) as s, case when n=-1 or SUM(n) over (partition by employee_id order by t)>1 then TIMESTAMPDIFF(minute, LAG(t) over (partition by employee_id order by t), t) else 0 end as t
from total)
select employee_id, FLOOR(SUM(t)/60) as total_task_hours, MAX(s) as max_concurrent_tasks
from s
group by employee_id
