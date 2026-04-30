/*
 * Problem: 2752. Customers with Maximum Number of Transactions on Consecutive Days
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/customers-with-maximum-number-of-transactions-on-consecutive-days/
 * Language: mysql
 * Date: 2026-04-30
 */

# Write your MySQL query statement below
with prv as (
    select *, LAG(transaction_date) over (partition by customer_id order by transaction_date) as prv, LEAD(transaction_date) over (partition by customer_id order by transaction_date) as next
    from Transactions
),
rng as (
    select customer_id, transaction_date, prv, 'start' as t
    from prv
    where prv is null or DATEDIFF(transaction_date,prv)!=1
    union all
    select customer_id, transaction_date, next, 'end'
    from prv
    where next is null or DATEDIFF(next,transaction_date)!=1
),
diff as (
    select customer_id, DATEDIFF(transaction_date,LAG(transaction_date) over (partition by customer_id order by transaction_date)) as diff, t
    from rng
),
rnk as (
    select customer_id, RANK() over(order by diff desc) as r
    from diff
    where t='end'
)
select customer_id
from rnk
where r=1
order by customer_id
