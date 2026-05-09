/*
 * Problem: 3657. Find Loyal Customers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-loyal-customers/
 * Language: mysql
 * Date: 2026-05-09
 */

# Write your MySQL query statement below
with t as (
    select *, (case when transaction_type='refund' then 1 else 0 end) as ref
    from customer_transactions
)
select customer_id
from t
group by customer_id
having MIN(transaction_date)+interval 30 day<=MAX(transaction_date) and COUNT(*)>=3 and SUM(ref)/COUNT(*)<0.2
order by customer_id
