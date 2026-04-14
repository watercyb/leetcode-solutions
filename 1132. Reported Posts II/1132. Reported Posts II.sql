/*
 * Problem: 1132. Reported Posts II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reported-posts-ii/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
with a as (select distinct post_id, action_date
from Actions
where extra='spam')
select ROUND(AVG(p)*100,2) as average_daily_percent 
from
(select SUM(case when post_id in (select post_id from Removals) then 1 else 0 end)/COUNT(post_id) as p
from a
group by action_date) as a
