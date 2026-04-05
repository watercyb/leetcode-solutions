/*
 * Problem: 615. Average Salary: Departments VS Company
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/average-salary-departments-vs-company/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
with avg as (select DATE_FORMAT(pay_date,"%Y-%m") as "month", AVG(amount) as amount from Salary group by DATE_FORMAT(pay_date,"%Y-%m"))
select DATE_FORMAT(a.pay_date,"%Y-%m") as pay_month, b.department_id,
(case when ROUND(AVG(a.amount),4)>ROUND((select amount from avg where month=DATE_FORMAT(a.pay_date,"%Y-%m") limit 1),4) then "higher"
when AVG(a.amount)<(select amount from avg where month=DATE_FORMAT(a.pay_date,"%Y-%m") limit 1) then "lower" else
"same" end) as comparison
from Salary as a, Employee as b
where a.employee_id=b.employee_id
group by pay_month, department_id
