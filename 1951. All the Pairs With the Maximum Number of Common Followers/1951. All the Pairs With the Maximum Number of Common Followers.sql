/*
 * Problem: 1951. All the Pairs With the Maximum Number of Common Followers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/all-the-pairs-with-the-maximum-number-of-common-followers/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
with a as (select a.user_id as user1_id, b.user_id as user2_id, RANK() over (order by COUNT(*) desc) as r
from Relations as a, Relations as b
where a.user_id<b.user_id and a.follower_id=b.follower_id
group by a.user_id, b.user_id)
select user1_id, user2_id
from a
where r=1
