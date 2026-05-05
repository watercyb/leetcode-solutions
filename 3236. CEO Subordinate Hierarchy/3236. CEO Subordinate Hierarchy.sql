/*
 * Problem: 3236. CEO Subordinate Hierarchy
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/ceo-subordinate-hierarchy/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
with recursive rec as (
    select employee_id, employee_name, 0 as lv, salary as cs, salary
    from Employees
    where manager_id is null
    union all
    select a.employee_id, a.employee_name, b.lv+1, b.cs, a.salary
    from Employees as a, rec as b
    where a.manager_id=b.employee_id
)
select employee_id as subordinate_id, employee_name as subordinate_name, lv as hierarchy_level, salary-cs as salary_difference
from rec
where lv!=0
order by hierarchy_level, subordinate_id
