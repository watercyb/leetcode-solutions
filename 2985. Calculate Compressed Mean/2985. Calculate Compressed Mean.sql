/*
 * Problem: 2985. Calculate Compressed Mean
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/calculate-compressed-mean/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
select ROUND(SUM(item_count*order_occurrences)/SUM(order_occurrences),2) as average_items_per_order
from Orders
