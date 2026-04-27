/*
 * Problem: 2474. Customers With Strictly Increasing Purchases
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/customers-with-strictly-increasing-purchases/
 * Language: mysql
 * Date: 2026-04-27
 */

# Write your MySQL query statement below
with total as (select customer_id, YEAR(order_date) as y, SUM(price) as p
from Orders
group by customer_id, y),
prv as (select *, IFNULL(LAG(p) over (partition by customer_id order by y), 0) as prv, LAG(y) over (partition by customer_id order by y) as prvY
from total),
s as (select customer_id, SUM(case when prv>=p then 1 else 0 end) as s, SUM(case when y-prvY>1 then 1 else 0 end) as y
from prv
group by customer_id)
select customer_id
from s
where s=0 and y=0
