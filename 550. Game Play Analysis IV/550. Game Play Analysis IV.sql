/*
 * Problem: 550. Game Play Analysis IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/game-play-analysis-iv/
 * Language: mysql
 * Date: 2026-04-03
 */

# Write your MySQL query statement below
select ROUND(COUNT(player_id)/(select COUNT(distinct player_id) from Activity),2) as fraction
from Activity
where (player_id, event_date-interval 1 day) in
(select player_id, MIN(event_date) from Activity group by player_id)
