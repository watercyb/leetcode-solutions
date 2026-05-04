/*
 * Problem: 3118. Friday Purchase III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/friday-purchase-iii/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with tab as (
    select WEEK(a.purchase_date)-WEEK('2023-11-01')+1 as w, b.membership, SUM(a.amount_spend) as sm
    from Purchases as a, Users as b
    where WEEKDAY(a.purchase_date)=4 and a.user_id=b.user_id and (b.membership='Premium' or b.membership='VIP')
    group by a.purchase_date, b.membership
),
total as (
    select 1 as week_of_month, 'Premium' as membership
    union all
    select 1 as week_of_month, 'VIP' as membership
    union all
    select 2 as week_of_month, 'Premium' as membership
    union all
    select 2 as week_of_month, 'VIP' as membership
    union all
    select 3 as week_of_month, 'Premium' as membership
    union all
    select 3 as week_of_month, 'VIP' as membership
    union all
    select 4 as week_of_month, 'Premium' as membership
    union all
    select 4 as week_of_month, 'VIP' as membership
)
select a.*, IFNULL(b.sm,0) as total_amount
from total as a
left join tab as b
on a.week_of_month=b.w and a.membership=b.membership
