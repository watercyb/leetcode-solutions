/*
 * Problem: 3214. Year on Year Growth Rate
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/year-on-year-growth-rate/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
with spd as (select YEAR(transaction_date) as year, product_id, SUM(spend) as spend
from user_transactions
group by year, product_id),
lg as (select year, product_id, spend as curr_year_spend, LAG(spend) over (partition by product_id order by year) as prev_year_spend
from spd)
select *, ROUND((curr_year_spend-prev_year_spend)/prev_year_spend*100,2) as yoy_rate
from lg
