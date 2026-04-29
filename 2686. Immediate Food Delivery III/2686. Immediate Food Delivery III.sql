/*
 * Problem: 2686. Immediate Food Delivery III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/immediate-food-delivery-iii/
 * Language: mysql
 * Date: 2026-04-29
 */

# Write your MySQL query statement below
select order_date, ROUND(SUM(case when order_date=customer_pref_delivery_date then 1 else 0 end)/COUNT(*)*100,2) as immediate_percentage
from Delivery
group by order_date
order by order_date
