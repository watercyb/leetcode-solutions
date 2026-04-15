/*
 * Problem: 1270. All People Report to the Given Manager
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-people-report-to-the-given-manager/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select a.employee_id
from Employees as a, Employees as b, Employees as c
where a.manager_id=b.employee_id and b.manager_id=c.employee_id and c.manager_id=1 and a.employee_id!=1
