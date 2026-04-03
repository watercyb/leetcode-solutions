/*
 * Problem: 511. Game Play Analysis I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/game-play-analysis-i/
 * Language: mysql
 * Date: 2026-04-03
 */

# Write your MySQL query statement below
select player_id, min(event_date) as first_login
from Activity
group by player_id
