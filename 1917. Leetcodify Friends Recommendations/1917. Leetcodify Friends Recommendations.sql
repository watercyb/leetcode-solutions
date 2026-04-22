/*
 * Problem: 1917. Leetcodify Friends Recommendations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/leetcodify-friends-recommendations/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
with a as (select a.user_id as user1_id, b.user_id as user2_id, a.day, COUNT(distinct a.song_id) as cnt
from Listens as a, Listens as b
where a.user_id<b.user_id and a.song_id=b.song_id and a.day=b.day and not exists (select * from Friendship where user1_id=a.user_id and user2_id=b.user_id)
group by a.user_id, b.user_id, a.day
having cnt>=3)
select distinct user1_id as user_id, user2_id as recommended_id
from a
union all
select distinct user2_id, user1_id
from a
