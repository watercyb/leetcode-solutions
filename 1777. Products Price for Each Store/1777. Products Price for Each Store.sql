/*
 * Problem: 1777. Product's Price for Each Store
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/products-price-for-each-store/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select product_id, SUM(case when store='store1' then price end) as store1, SUM(case when store='store2' then price end) as store2, SUM(case when store='store3' then price end) as store3
from Products
group by product_id
