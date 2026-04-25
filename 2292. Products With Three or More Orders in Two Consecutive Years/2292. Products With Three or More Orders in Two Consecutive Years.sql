/*
 * Problem: 2292. Products With Three or More Orders in Two Consecutive Years
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/products-with-three-or-more-orders-in-two-consecutive-years/
 * Language: mysql
 * Date: 2026-04-25
 */

# Write your MySQL query statement below
with cnt as (select product_id, COUNT(*) as cnt, YEAR(purchase_date) as y
from Orders
group by product_id, YEAR(purchase_date)
having cnt>=3),
prv as (select product_id, y, LAG(y) over (partition by product_id order by y) as prv
from cnt)
select distinct product_id
from prv
where y-prv=1
