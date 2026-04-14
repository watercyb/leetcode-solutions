/*
 * Problem: 1159. Market Analysis II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/market-analysis-ii/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
with r as (select item_id, seller_id, ROW_NUMBER() over (partition by seller_id order by order_date) as r
from Orders
group by item_id, seller_id, order_date),
secItem as (select b.item_brand, a.seller_id
from r as a, Items as b
where a.r=2 and a.item_id=b.item_id),
y as (select seller_id
from secItem
where (seller_id, item_brand) in (select user_id, favorite_brand from Users))
select user_id as seller_id, (case when user_id in (select seller_id from y) then 'yes' else 'no' end) as 2nd_item_fav_brand
from Users
