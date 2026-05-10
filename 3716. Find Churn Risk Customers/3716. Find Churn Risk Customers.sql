/*
 * Problem: 3716. Find Churn Risk Customers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-churn-risk-customers/
 * Language: mysql
 * Date: 2026-05-10
 */

# Write your MySQL query statement below
with t as (
    select *
    from subscription_events
    where user_id not in (select user_id from subscription_events where plan_name is null)
),
t1 as (
    select *, RANK() over (partition by user_id order by event_date desc) as r
    from t
),
t2 as (
    select user_id, MIN(event_date) as mi, MAX(event_date) as mx, MAX(monthly_amount) as mxP
    from t
    group by user_id
),
t3 as (
    select b.*, a.plan_name, a.monthly_amount
    from t1 as a, t2 as b
    where a.user_id=b.user_id and a.r=1
)
select user_id, plan_name as current_plan, monthly_amount as current_monthly_amount, mxP as max_historical_amount, DATEDIFF(mx, mi) as days_as_subscriber
from t3
where monthly_amount/mxP<0.5
having days_as_subscriber>=60
order by days_as_subscriber desc, user_id
