/*
 * Problem: 1174. Immediate Food Delivery II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/immediate-food-delivery-ii/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select ROUND(SUM(case when order_date=customer_pref_delivery_date then 1 else 0 end)/COUNT(*)*100,2) as immediate_percentage
from
(select *
from
    (select customer_id, order_date, customer_pref_delivery_date, rank() over (partition by customer_id order by order_date) as r
from Delivery) as a
where r=1) as a
