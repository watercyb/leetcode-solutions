/*
 * Problem: 1841. League Statistics
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/league-statistics/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select a.team_name, COUNT(*) as matches_played, SUM(b.score) as points, SUM(b.goal) as goal_for, SUM(b.goal_ag) as goal_against, SUM(b.goal)-SUM(b.goal_ag) as goal_diff
from Teams as a,
(select home_team_id as id, (case when home_team_goals>away_team_goals then 3 when home_team_goals=away_team_goals then 1 else 0 end) as score, home_team_goals as goal, away_team_goals as goal_ag
from Matches
union all
select away_team_id, (case when home_team_goals<away_team_goals then 3 when home_team_goals=away_team_goals then 1 else 0 end) as score, away_team_goals as goal, home_team_goals as goal_ag
from Matches) as b
where a.team_id=b.id
group by a.team_name
order by points desc, goal_diff desc, team_name
