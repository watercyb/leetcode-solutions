/*
 * Problem: 1677. Product's Worth Over Invoices
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/products-worth-over-invoices/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select a.name, IFNULL(SUM(b.rest),0) as rest, IFNULL(SUM(b.paid),0) as paid, IFNULL(SUM(b.canceled),0) as canceled, IFNULL(SUM(b.refunded),0) as refunded
from Product as a
left join Invoice as b
on a.product_id=b.product_id
group by a.name
order by a.name
