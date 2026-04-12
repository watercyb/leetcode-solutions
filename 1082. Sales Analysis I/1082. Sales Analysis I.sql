/*
 * Problem: 1082. Sales Analysis I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sales-analysis-i/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
with a as (select seller_id, SUM(price) as sum
from Sales
group by seller_id
order by sum desc)
select seller_id
from a
where sum = (select MAX(sum) from a)
