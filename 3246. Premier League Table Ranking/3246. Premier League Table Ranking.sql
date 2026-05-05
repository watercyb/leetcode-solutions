/*
 * Problem: 3246. Premier League Table Ranking
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/premier-league-table-ranking/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
select *, RANK() over (order by points desc) as position
from
(select team_id, team_name, wins*3+draws as points
from TeamStats) as a
order by position, team_name
