/*
 * Problem: 1919. Leetcodify Similar Friends
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/leetcodify-similar-friends/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
with a as (select a.user_id as user1_id, b.user_id as user2_id, a.day, COUNT(distinct a.song_id) as cnt
from Listens as a, Listens as b
where a.user_id<b.user_id and a.song_id=b.song_id and a.day=b.day
group by a.user_id, b.user_id, a.day
having cnt>=3)
select distinct user1_id, user2_id
from a
where user1_id in (select user1_id from Friendship where user2_id=a.user2_id)
