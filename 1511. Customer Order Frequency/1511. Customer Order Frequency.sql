/*
 * Problem: 1511. Customer Order Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/customer-order-frequency/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
with a as (select a.customer_id, DATE_FORMAT(a.order_date,'%Y-%m') as date, SUM(b.price*a.quantity) as total
from Orders as a, Product as b
where a.product_id=b.product_id
group by a.customer_id, date
having total>=100)
select customer_id, name
from Customers
where customer_id in (select customer_id from a where date='2020-06') and customer_id in (select customer_id from a where date='2020-07')
