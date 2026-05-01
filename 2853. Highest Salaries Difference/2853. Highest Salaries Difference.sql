/*
 * Problem: 2853. Highest Salaries Difference
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/highest-salaries-difference/
 * Language: mysql
 * Date: 2026-05-01
 */

# Write your MySQL query statement below
select ABS(MAX(case when department='Marketing' then salary else 0 end)-MAX(case when department='Engineering' then salary else 0 end)) as salary_difference
from Salaries
