/*
 * Problem: 2986. Find Third Transaction
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-third-transaction/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with prv as (
    select *, LAG(spend,1,10000000) over (partition by user_id order by transaction_date) as a, LAG(spend,2,10000000) over (partition by    user_id order by transaction_date) as b, LAG(spend,3) over (partition by user_id order by transaction_date) as c
    from Transactions
)
select user_id, spend as third_transaction_spend, transaction_date as third_transaction_date
from prv
where a<spend and b<spend and c is null
