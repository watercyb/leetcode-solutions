/*
 * Problem: 1264. Page Recommendations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/page-recommendations/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
with friendsLike as (select b.page_id
from (select distinct (case when user1_id=1 then user2_id when user2_id=1 then user1_id end) as id
from Friendship) as a,
Likes as b
where a.id=b.user_id)
select distinct page_id as recommended_page
from Likes
having page_id in (select page_id from friendsLike) and page_id not in (select page_id from Likes where user_id=1)
