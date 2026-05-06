/*
 * Problem: 3322. Premier League Table Ranking III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/premier-league-table-ranking-iii/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
select season_id, team_id, team_name, wins*3+draws as points, goals_for-goals_against as goal_difference, RANK() over (partition by season_id order by wins*3+draws desc, goals_for-goals_against desc, team_name) as 'position'
from SeasonStats
order by season_id, position, team_name
