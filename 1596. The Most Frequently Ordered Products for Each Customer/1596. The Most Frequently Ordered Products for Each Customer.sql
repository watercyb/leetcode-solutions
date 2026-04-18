/*
 * Problem: 1596. The Most Frequently Ordered Products for Each Customer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-most-frequently-ordered-products-for-each-customer/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select a.customer_id, a.product_id, b.product_name
from
(select customer_id, product_id, rank() over (partition by customer_id order by COUNT(*) desc) as r
from Orders
group by customer_id, product_id) as a,
Products as b
where a.r=1 and a.product_id=b.product_id
