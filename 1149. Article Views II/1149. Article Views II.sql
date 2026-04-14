/*
 * Problem: 1149. Article Views II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/article-views-ii/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select distinct viewer_id as id
from views
group by viewer_id, view_date
having COUNT(distinct article_id)>=2
order by viewer_id
