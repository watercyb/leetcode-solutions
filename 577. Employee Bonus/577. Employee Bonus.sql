/*
 * Problem: 577. Employee Bonus
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/employee-bonus/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select a.name, b.bonus
from Employee as a
left join Bonus as b
on a.empId=b.empId
where bonus<1000 or bonus is null
