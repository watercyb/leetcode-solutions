/*
 * Problem: 2394. Employees With Deductions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/employees-with-deductions/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with s as (
    select employee_id, SUM(CEIL(TIMESTAMPDIFF(SECOND, in_time, out_time)/60))/60 as t
    from Logs
    group by employee_id
),
needs as (
    select a.*, b.t
    from Employees as a
    left join s as b
    on a.employee_id=b.employee_id
    having t is null or t<needed_hours
)
select employee_id
from needs
