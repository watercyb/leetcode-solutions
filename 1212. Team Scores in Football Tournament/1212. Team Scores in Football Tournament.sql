/*
 * Problem: 1212. Team Scores in Football Tournament
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/team-scores-in-football-tournament/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
with list as (select host_team as team_id, SUM(case when host_goals>guest_goals then 3 else 1 end) as num_points
from Matches
where host_goals>guest_goals or host_goals=guest_goals
group by team_id
union all
select guest_team as team_id, SUM(case when host_goals<guest_goals then 3 else 1 end) as num_points
from Matches
where host_goals<guest_goals or host_goals=guest_goals
group by team_id),
points as (select team_id, SUM(num_points) as num_points
from list
group by team_id)
select a.team_id, a.team_name, IFNULL(b.num_points,0) as num_points
from Teams as a
left join points as b
on a.team_id=b.team_id
order by num_points desc, team_id
