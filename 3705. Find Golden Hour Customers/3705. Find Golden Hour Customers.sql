/*
 * Problem: 3705. Find Golden Hour Customers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-golden-hour-customers/
 * Language: mysql
 * Date: 2026-05-10
 */

# Write your MySQL query statement below
with grp as (
    select *, SUM(case when (TIME(order_timestamp)>='11:00' and TIME(order_timestamp)<='14:00') or (TIME(order_timestamp)>='18:00' and TIME(order_timestamp)<='21:00') then 1 else 0 end) as ph, SUM(case when order_rating is not null then 1 else 0 end) as rt, COUNT(*) as total_orders, ROUND(AVG(order_rating),2) as average_rating
    from restaurant_orders
    group by customer_id
)
select customer_id, total_orders, ROUND(ph/total_orders,2)*100 as peak_hour_percentage, average_rating
from grp
where total_orders>=3 and ph/total_orders>=0.6 and average_rating>=4 and rt/total_orders>=0.5
order by average_rating desc, customer_id desc
