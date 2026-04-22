/*
 * Problem: 1978. Employees Whose Manager Left the Company
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/employees-whose-manager-left-the-company/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
select employee_id
from Employees
where manager_id not in (select employee_id from Employees) and salary<30000
order by employee_id
