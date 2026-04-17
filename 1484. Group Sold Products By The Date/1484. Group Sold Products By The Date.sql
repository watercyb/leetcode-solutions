/*
 * Problem: 1484. Group Sold Products By The Date
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/group-sold-products-by-the-date/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select sell_date, COUNT(distinct product) as num_sold, GROUP_CONCAT(distinct product order by product separator ',') as products
from Activities
group by sell_date
