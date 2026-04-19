/*
 * Problem: 1607. Sellers With No Sales
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sellers-with-no-sales/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
with a as (select seller_id
from Orders
where DATE_FORMAT(sale_date,'%Y')='2020')
select seller_name
from Seller
where seller_id not in (select seller_id from a)
order by seller_name
