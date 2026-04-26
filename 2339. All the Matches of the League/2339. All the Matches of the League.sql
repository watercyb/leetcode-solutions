/*
 * Problem: 2339. All the Matches of the League
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/all-the-matches-of-the-league/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
select a.team_name as home_team, b.team_name as away_team
from Teams as a, Teams as b
where a.team_name!=b.team_name
