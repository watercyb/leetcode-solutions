/*
 * Problem: 2175. The Change in Global Rankings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-change-in-global-rankings/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with r1 as (select team_id, name, RANK() over (order by points desc, name) as r
from TeamPoints),
r2 as (select a.team_id, RANK() over (order by a.points+b.points_change desc, a.name) as r, a.points+b.points_change as p
from TeamPoints as a
left join PointsChange as b
on a.team_id=b.team_id)
select a.team_id, a.name, CAST(a.r as signed)-CAST(b.r as signed) as rank_diff
from r1 as a, r2 as b
where a.team_id=b.team_id
