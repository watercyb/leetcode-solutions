/*
 * Problem: 1747. Leetflex Banned Accounts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/leetflex-banned-accounts/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select distinct a.account_id
from LogInfo as a, LogInfo as b
where a.account_id=b.account_id and a.ip_address!=b.ip_address and a.login<=b.logout&&b.login<=a.logout
