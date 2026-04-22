/*
 * Problem: 1907. Count Salary Categories
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-salary-categories/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
select 'Low Salary' as category, COUNT(*) as accounts_count
from Accounts
where income<20000
union
select 'Average Salary' as category, COUNT(*) as accounts_count
from Accounts
where income>=20000 and income<=50000
union
select 'High Salary' as category, COUNT(*) as accounts_count
from Accounts
where income>50000
