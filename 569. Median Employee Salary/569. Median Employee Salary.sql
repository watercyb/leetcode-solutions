/*
 * Problem: 569. Median Employee Salary
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/median-employee-salary/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
with a as (select id, company, rank() over (partition by company order by salary, id) as r
from Employee),
b as (select company, COUNT(*) as c
from Employee
group by company)
select c.*
from a, b, Employee as c
where c.company=b.company and c.company=a.company and c.id=a.id and a.r>=b.c/2 and a.r<=b.c/2+1
