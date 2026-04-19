/*
 * Problem: 1661. Average Time of Process per Machine
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/average-time-of-process-per-machine/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select machine_id, ROUND(AVG(time),3) as processing_time
from
(select machine_id, MAX(timestamp) over (partition by machine_id, process_id)-MIN(timestamp) over (partition by machine_id, process_id) as time
from Activity) as a
group by machine_id
