/*
 * Problem: 181. Employees Earning More Than Their Managers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/employees-earning-more-than-their-managers/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select a.name as 'Employee'
from Employee as a join Employee as b
on a.managerId=b.id and a.salary>b.salary
