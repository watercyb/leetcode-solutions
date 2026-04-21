/*
 * Problem: 1843. Suspicious Bank Accounts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/suspicious-bank-accounts/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
with a as (select a.account_id, DATE_FORMAT(a.day,'%Y') as year, DATE_FORMAT(a.day,'%m') as month, SUM(a.amount) as sum, b.max_income
from Transactions as a, Accounts as b
where a.account_id=b.account_id and a.type='Creditor'
group by account_id, year, month
having sum>max_income)
select distinct a.account_id
from a as a, a as b
where a.account_id=b.account_id and DATE_ADD(CONCAT(a.year, '-', a.month, '-01'), interval 1 month)=CONCAT(b.year, '-', b.month, '-01')
