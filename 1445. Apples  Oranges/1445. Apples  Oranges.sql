/*
 * Problem: 1445. Apples & Oranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apples-oranges/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select sale_date, SUM(case when fruit='apples' then sold_num else -sold_num end) as diff
from Sales
group by sale_date
