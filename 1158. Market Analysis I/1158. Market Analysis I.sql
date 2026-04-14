/*
 * Problem: 1158. Market Analysis I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/market-analysis-i/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select a.user_id as buyer_id, a.join_date, COUNT(b.order_id) as orders_in_2019
from Users as a
left join Orders as b
on a.user_id=b.buyer_id and YEAR(b.order_date)='2019'
group by a.user_id
