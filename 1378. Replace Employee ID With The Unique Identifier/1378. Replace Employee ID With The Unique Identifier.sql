/*
 * Problem: 1378. Replace Employee ID With The Unique Identifier
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select b.unique_id, a.name
from Employees as a
left join EmployeeUNI as b
on a.id=b.id
