/*
 * Problem: 1173. Immediate Food Delivery I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/immediate-food-delivery-i/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select ROUND(AVG(order_date = customer_pref_delivery_date)*100,2) as immediate_percentage
from Delivery
