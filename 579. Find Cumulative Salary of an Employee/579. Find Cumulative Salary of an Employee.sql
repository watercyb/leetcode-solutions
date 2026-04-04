/*
 * Problem: 579. Find Cumulative Salary of an Employee
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-cumulative-salary-of-an-employee/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select a.id, a.month, a.salary+IFNULL(b.salary,0)+IFNULL(c.salary,0) as salary
from Employee as a
left join Employee as b
on a.id=b.id and a.month-1=b.month
left join Employee as c
on a.id=c.id and a.month-2=c.month
where (a.id, a.month) not in (select id, MAX(month) from Employee group by id)
order by id, month desc
