/*
 * Problem: 1468. Calculate Salaries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/calculate-salaries/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
with p as (select company_id, (case when MAX(salary)<1000 then 1 when MAX(salary)<=10000 then 0.76 else 0.51 end) as p
from Salaries
group by company_id)
select a.company_id, a.employee_id, a.employee_name, ROUND(a.salary*b.p,0) as salary
from Salaries as a, p as b
where a.company_id=b.company_id
