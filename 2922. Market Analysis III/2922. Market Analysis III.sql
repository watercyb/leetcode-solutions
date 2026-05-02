/*
 * Problem: 2922. Market Analysis III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/market-analysis-iii/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with grp as (select a.seller_id, COUNT(distinct c.item_id) as num_items
from Users as a, Orders as b, Items as c
where a.seller_id=b.seller_id and b.item_id=c.item_id and a.favorite_brand!=c.item_brand
group by a.seller_id),
rnk as (select *, RANK() over (order by num_items desc) as r
from grp)
select seller_id, num_items
from rnk
where r=1
