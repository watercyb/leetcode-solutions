/*
 * Problem: 1045. Customers Who Bought All Products
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/customers-who-bought-all-products/
 * Language: mysql
 * Date: 2026-04-11
 */

# Write your MySQL query statement below
select customer_id
from Customer
group by customer_id
having COUNT(distinct product_key)=(select COUNT(*) from Product)
