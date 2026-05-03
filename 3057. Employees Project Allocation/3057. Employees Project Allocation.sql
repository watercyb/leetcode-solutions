/*
 * Problem: 3057. Employees Project Allocation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/employees-project-allocation/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with total as (
    select a.employee_id, a.project_id, b.name, b.team, a.workload
    from Project as a, Employees as b
    where a.employee_id=b.employee_id
),
avge as (
    select team, AVG(workload) as avge
    from total
    group by team
)
select employee_id, project_id, name as employee_name, workload as project_workload
from total
where workload > (select avge from avge where avge.team = total.team)
order by employee_id, project_id
