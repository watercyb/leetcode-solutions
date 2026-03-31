/*
 * Problem: 3322. Premier League Table Ranking III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/premier-league-table-ranking-iii/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-03-31
 */

# Write your MySQL query statement below
select season_id, team_id, team_name, wins*3+draws as points, goals_for-goals_against as goal_difference, RANK() over (partition by season_id order by wins*3+draws desc, goals_for-goals_against desc, team_name) as 'position'
from SeasonStats
order by season_id, position, team_name
