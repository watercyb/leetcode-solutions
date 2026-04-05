/*
 * Problem: 607. Sales Person
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sales-person/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select distinct name
from SalesPerson
where sales_id not in
(select b.sales_id
from Company as a, Orders as b
where a.com_id=b.com_id and a.name='RED')
