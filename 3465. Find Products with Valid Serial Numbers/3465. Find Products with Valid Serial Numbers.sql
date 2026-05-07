/*
 * Problem: 3465. Find Products with Valid Serial Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-products-with-valid-serial-numbers/
 * Language: mysql
 * Date: 2026-05-07
 */

# Write your MySQL query statement below
select *
from products
where description regexp '(^|[ ])SN[0-9]{4}-[0-9]{4}([ ]|$)'
order by product_id
