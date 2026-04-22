/*
 * Problem: 1949. Strong Friendship
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/strong-friendship/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
with a as (select *
from Friendship
union all
select user2_id, user1_id
from Friendship)
select a.user1_id, b.user1_id as user2_id, COUNT(*) as common_friend
from a as a, a as b
where a.user1_id<b.user1_id and a.user2_id=b.user2_id and a.user1_id in (select user1_id from Friendship where user2_id=b.user1_id)
group by a.user1_id, b.user1_id
having common_friend>=3
