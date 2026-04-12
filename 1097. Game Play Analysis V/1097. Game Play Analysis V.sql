/*
 * Problem: 1097. Game Play Analysis V
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/game-play-analysis-v/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
select event_date as install_dt, COUNT(player_id) as installs,
ROUND(SUM(case when (player_id, event_date + interval 1 day) in (select player_id, event_date from Activity) then 1 else 0 end)/COUNT(player_id),2) as Day1_retention
from (select player_id, MIN(event_date) as event_date
from Activity
group by player_id) as a
group by event_date
