/*
 * Problem: 1084. Sales Analysis III
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sales-analysis-iii/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select a.product_id, a.product_name
from Product as a
left join Sales as b
on a.product_id=b.product_id
group by product_id
having MIN(b.sale_date)>='2019-01-01' and MAX(b.sale_date)<='2019-03-31'
