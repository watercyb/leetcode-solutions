/*
 * Problem: 1327. List the Products Ordered in a Period
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/list-the-products-ordered-in-a-period/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select a.product_name, b.sum as unit
from Products as a,
(select product_id, SUM(unit) as sum
from Orders
where DATE_FORMAT(order_date,'%Y-%m')='2020-02'
group by product_id
having sum>=100) as b
where a.product_id=b.product_id
