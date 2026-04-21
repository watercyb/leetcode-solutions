/*
 * Problem: 1873. Calculate Special Bonus
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/calculate-special-bonus/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select employee_id, case when LEFT(name,1)!='M' and employee_id%2=1 then salary else 0 end as bonus
from Employees
order by employee_id
