/*
 * Problem: 2066. Account Balance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/account-balance/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
select account_id, day, SUM(case when type='Deposit' then amount else -amount end) over (partition by account_id order by day) as balance
from Transactions
