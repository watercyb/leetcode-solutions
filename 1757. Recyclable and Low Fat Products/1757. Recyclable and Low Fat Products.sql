/*
 * Problem: 1757. Recyclable and Low Fat Products
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/recyclable-and-low-fat-products/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select product_id
from Products
where low_fats='Y' and recyclable='Y'
