/*
 * Problem: 1555. Bank Account Summary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bank-account-summary/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
with a as (select a.user_id, a.user_name, a.credit-IFNULL(SUM(b.amount),0) as amount
from Users as a
left join Transactions as b
on a.user_id=b.paid_by
group by a.user_id),
b as (select a.user_id, a.user_name, a.amount+IFNULL(SUM(b.amount),0) as credit
from a as a
left join Transactions as b
on a.user_id=b.paid_to
group by a.user_id)
select *, (case when credit>=0 then 'No' else 'Yes' end) as credit_limit_breached
from b
