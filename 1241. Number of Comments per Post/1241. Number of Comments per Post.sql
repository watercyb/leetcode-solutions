/*
 * Problem: 1241. Number of Comments per Post
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-comments-per-post/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select a.sub_id as post_id, COUNT(b.sub_id) as number_of_comments
from
(select distinct sub_id from Submissions where parent_id is null) as a 
left join
(select distinct sub_id, parent_id from Submissions) as b
on a.sub_id=b.parent_id
group by post_id
order by post_id
