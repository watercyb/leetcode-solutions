/*
 * Problem: 1211. Queries Quality and Percentage
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/queries-quality-and-percentage/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select a.query_name,ROUND(AVG(rating/position),2) as quality, ROUND(SUM(case when rating<3 then 1 else 0 end)/COUNT(*)*100,2) as poor_query_percentage
from Queries as a
where query_name is not null
group by a.query_name
