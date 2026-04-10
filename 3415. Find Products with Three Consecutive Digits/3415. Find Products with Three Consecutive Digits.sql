/*
 * Problem: 3415. Find Products with Three Consecutive Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-products-with-three-consecutive-digits/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-10
 */

# Write your MySQL query statement below
select *
from Products
where name regexp '^[^0-9]*[0-9]{3}[^0-9]*$'
order by product_id
