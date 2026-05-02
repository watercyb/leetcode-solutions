/*
 * Problem: 2994. Friday Purchases II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/friday-purchases-ii/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with recursive rec as (
    select '2023-11-01' as d, 1 as week_of_month
    union all
    select d+INTERVAL 1 day as d, WEEK(d+INTERVAL 1 day)-WEEK('2023-11-01')+1 as week_of_month
    from rec
    where d<'2023-11-30'
),
friday as (
    select *
    from rec
    where DAYOFWEEK(d)=6
)
select a.week_of_month, a.d as purchase_date, IFNULL(SUM(b.amount_spend),0) as total_amount
from friday as a
left join Purchases as b
on a.d=b.purchase_date
group by d
