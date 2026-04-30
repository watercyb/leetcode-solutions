/*
 * Problem: 2701. Consecutive Transactions with Increasing Amounts
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/consecutive-transactions-with-increasing-amounts/
 * Language: mysql
 * Date: 2026-04-30
 */

# Write your MySQL query statement below
with dataSet1 as (
    select a.customer_id, a.transaction_date, rank() over (partition by customer_id order by transaction_date) as r
    from Transactions as a, Transactions as b
    where a.customer_id=b.customer_id and a.transaction_date+interval 1 day=b.transaction_date and a.amount<b.amount
),
dataSet2 as (
    select a.customer_id, a.transaction_date, MAX(b.transaction_date)+interval 1 day as consecutive_end
    from dataSet1 as a, dataSet1 as b
    where a.customer_id=b.customer_id and a.transaction_date<b.transaction_date and
    DATEDIFF(b.transaction_date,a.transaction_date)=b.r-a.r
    group by customer_id, transaction_date
)
select customer_id, MIN(transaction_date) as consecutive_start, consecutive_end as consecutive_end
from dataSet2
group by customer_id, consecutive_end
order by customer_id
