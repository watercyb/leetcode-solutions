/*
 * Problem: 176. Second Highest Salary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/second-highest-salary/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select IFNULL((select salary
from Employee
group by salary
order by salary desc
limit 1 offset 1),null) as SecondHighestSalary 
