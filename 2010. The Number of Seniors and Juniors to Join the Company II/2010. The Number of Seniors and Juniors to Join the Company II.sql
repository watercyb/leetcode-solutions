/*
 * Problem: 2010. The Number of Seniors and Juniors to Join the Company II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-number-of-seniors-and-juniors-to-join-the-company-ii/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
with sum1 as (select *, SUM(salary) over (partition by experience order by salary) as s
from Candidates),
sum2 as (select employee_id, experience, salary
from sum1
where s<=70000),
sum3 as (select *, SUM(salary) over (order by experience, salary) as s
from sum2)
select employee_id
from sum3
where s<=70000
