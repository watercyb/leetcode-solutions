/*
 * Problem: 1398. Customers Who Bought Products A and B but Not C
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/customers-who-bought-products-a-and-b-but-not-c/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select a.customer_id, b.customer_name
from Orders as a, Customers as b
where a.customer_id=b.customer_id
group by customer_id
having SUM(a.product_name='A')>0 and SUM(a.product_name='B')>0 and SUM(a.product_name='C')=0
