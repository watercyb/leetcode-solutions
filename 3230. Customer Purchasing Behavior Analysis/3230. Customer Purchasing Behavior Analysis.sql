/*
 * Problem: 3230. Customer Purchasing Behavior Analysis
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/customer-purchasing-behavior-analysis/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
with total as (
    select a.*, b.category, b.price
    from Transactions as a, Products as b
    where a.product_id=b.product_id
),
grp as (
    select customer_id, SUM(amount) as total_amount, COUNT(*) as transaction_count,  ROUND(COUNT(distinct category),2) as unique_categories,  ROUND(SUM(amount)/COUNT(*),2) as avg_transaction_amount, ROUND(COUNT(*)*10+SUM(amount)/100,2) as loyalty_score
    from total
    group by customer_id
),
rnk as (
    select customer_id, category, RANK() over (partition by customer_id order by COUNT(*) desc, MAX(transaction_date) desc) as r
    from total
    group by customer_id, category
)
select a.customer_id, a.total_amount, a.transaction_count, a.unique_categories, a.avg_transaction_amount, b.category as top_category, a.loyalty_score
from grp as a,
(
    select *
    from rnk
    where r=1 
) as b
where a.customer_id=b.customer_id
order by loyalty_score desc, customer_id
