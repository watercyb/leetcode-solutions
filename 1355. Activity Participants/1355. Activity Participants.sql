/*
 * Problem: 1355. Activity Participants
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/activity-participants/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select name as activity
from
(select a.name, RANK() over (order by COUNT(b.name)) as a, RANK() over (order by COUNT(b.name) desc) as b
from Activities as a, Friends as b
where a.name=b.activity
group by a.name) as a
where a!=1 and b!=1
