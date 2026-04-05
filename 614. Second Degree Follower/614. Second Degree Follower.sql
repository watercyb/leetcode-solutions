/*
 * Problem: 614. Second Degree Follower
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/second-degree-follower/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select followee as follower, COUNT(follower) as num
from Follow
where followee in (select distinct follower from Follow)
group by followee
order by followee
