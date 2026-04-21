/*
 * Problem: 1892. Page Recommendations II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/page-recommendations-ii/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
with a as (select user1_id, user2_id
from Friendship
union all
select user2_id, user1_id
from Friendship)
select a.user1_id as user_id, b.page_id, COUNT(*) as friends_likes
from a as a
left join Likes as b
on a.user2_id=b.user_id
left join Likes as c
on a.user1_id=c.user_id and b.page_id=c.page_id
where c.page_id is null
group by a.user1_id, b.page_id
