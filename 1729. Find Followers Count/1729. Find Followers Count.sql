/*
 * Problem: 1729. Find Followers Count
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-followers-count/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select user_id, COUNT(follower_id) as followers_count
from Followers
group by user_id
order by user_id
