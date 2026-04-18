/*
 * Problem: 1587. Bank Account Summary II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/bank-account-summary-ii/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select a.name, SUM(b.amount) as balance
from Users as a, Transactions as b
where a.account=b.account
group by a.name
having balance>10000
