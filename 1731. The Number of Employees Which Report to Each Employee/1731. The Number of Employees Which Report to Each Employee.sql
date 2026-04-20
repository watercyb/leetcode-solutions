/*
 * Problem: 1731. The Number of Employees Which Report to Each Employee
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select a.employee_id, a.name, b.count as reports_count, b.age as average_age
from Employees as a,
(select reports_to, COUNT(employee_id) as count, ROUND(AVG(age),0) as age
from Employees
group by reports_to) as b
where a.employee_id=b.reports_to
order by employee_id
