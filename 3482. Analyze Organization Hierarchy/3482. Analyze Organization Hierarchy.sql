/*
 * Problem: 3482. Analyze Organization Hierarchy
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/analyze-organization-hierarchy/
 * Language: mysql
 * Date: 2026-05-07
 */

# Write your MySQL query statement below
with recursive rec as (
    select employee_id, employee_name, manager_id, salary, 1 as lv, CONCAT('#',employee_id,'#') as str
    from Employees as a
    where manager_id is null
    union all
    select b.employee_id, b.employee_name, b.manager_id, b.salary, a.lv+1 as lv, CONCAT(a.str,b.employee_id,'#') as str
    from rec as a, Employees as b
    where a.employee_id=b.manager_id
)
select a.employee_id, a.employee_name, a.lv as level, COUNT(*)-1 as team_size, SUM(b.salary) as budget
from rec as a, rec as b
where b.str like CONCAT('%#', a.employee_id, '#%')
group by a.employee_id
order by level, budget desc, employee_name
