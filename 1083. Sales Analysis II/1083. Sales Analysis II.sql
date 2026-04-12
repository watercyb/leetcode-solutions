/*
 * Problem: 1083. Sales Analysis II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sales-analysis-ii/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
with a as (select a.buyer_id, b.product_name
from Sales as a, Product as b
where a.product_id=b.product_id)
select distinct buyer_id
from Sales
where buyer_id in (select buyer_id from a where product_name='S8') and buyer_id not in (select buyer_id from a where product_name='iPhone')
