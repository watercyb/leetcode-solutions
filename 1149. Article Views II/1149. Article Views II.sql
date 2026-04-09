/*
 * Problem: 1149. Article Views II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/article-views-ii/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-09
 */

# Write your MySQL query statement below
select distinct viewer_id as id
from
(select viewer_id, view_date, COUNT(distinct article_id) as c
from Views
group by viewer_id, view_date
having c>1) as a
