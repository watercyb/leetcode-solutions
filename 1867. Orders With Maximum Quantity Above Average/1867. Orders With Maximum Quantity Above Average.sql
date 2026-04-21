/*
 * Problem: 1867. Orders With Maximum Quantity Above Average
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/orders-with-maximum-quantity-above-average/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
with a as (select order_id, AVG(quantity) as avg
from OrdersDetails
group by order_id)
select order_id
from OrdersDetails
group by order_id
having MAX(quantity)>(select MAX(avg) from a)
