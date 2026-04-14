/*
 * Problem: 1164. Product Price at a Given Date
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/product-price-at-a-given-date/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select a.product_id, a.new_price as price
from Products as a,
(select product_id, MAX(change_date) as change_date
from Products
where change_date<='2019-08-16'
group by product_id) as b
where a.product_id=b.product_id and a.change_date=b.change_date
union
select product_id, 10 as price
from Products
where product_id not in (select product_id from Products where change_date<='2019-08-16' group by product_id)
