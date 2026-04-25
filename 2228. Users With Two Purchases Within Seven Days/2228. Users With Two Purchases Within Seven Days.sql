/*
 * Problem: 2228. Users With Two Purchases Within Seven Days
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/users-with-two-purchases-within-seven-days/
 * Language: mysql
 * Date: 2026-04-25
 */

# Write your MySQL query statement below
with prv as (select user_id, purchase_date, LAG(purchase_date) over (partition by user_id order by purchase_date) as prv
from Purchases)
select distinct user_id
from prv
where DATEDIFF(purchase_date,prv) <= 7
