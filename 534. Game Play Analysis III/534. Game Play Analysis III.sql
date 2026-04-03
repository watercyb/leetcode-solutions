/*
 * Problem: 534. Game Play Analysis III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/game-play-analysis-iii/
 * Language: mysql
 * Date: 2026-04-03
 */

# Write your MySQL query statement below
select player_id, event_date, SUM(games_played) over (partition by player_id order by event_date) as games_played_so_far
from Activity
