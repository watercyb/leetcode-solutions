/*
 * Problem: 1148. Article Views I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/article-views-i/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select distinct author_id as id
from Views
where author_id=viewer_id
order by id
