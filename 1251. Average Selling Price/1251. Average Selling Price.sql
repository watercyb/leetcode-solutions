/*
 * Problem: 1251. Average Selling Price
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/average-selling-price/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select a.product_id, IFNULL(ROUND(SUM(a.price*b.units)/SUM(b.units),2),0) as average_price
from Prices as a
left join UnitsSold as b
on a.product_id=b.product_id and a.start_date<=b.purchase_date and a.end_date>=b.purchase_date
group by a.product_id
