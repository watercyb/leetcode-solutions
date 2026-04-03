/*
 * Problem: 512. Game Play Analysis II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/game-play-analysis-ii/
 * Language: mysql
 * Date: 2026-04-03
 */

# Write your MySQL query statement below
select player_id, device_id
from
(select player_id, device_id, RANK() over (partition by player_id order by event_date) as r
from Activity) as a
where r=1
