/*
 * Problem: 3338. Second Highest Salary II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/second-highest-salary-ii/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
with r as (
    select *, DENSE_RANK() over (partition by dept order by salary desc) as r
    from employees
)
select emp_id, dept
from r
where r=2
order by emp_id
