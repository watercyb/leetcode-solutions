/*
 * Problem: 3293. Calculate Product Final Price
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/calculate-product-final-price/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
select a.product_id, a.price*(1-IFNULL(b.discount/100,0)) as final_price, a.category
from Products as a
left join Discounts as b
on a.category=b.category
order by product_id
