/*
 * Problem: 3126. Server Utilization Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/server-utilization-time/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
select FLOOR(SUM(case when session_status='start' then TIMESTAMPDIFF(second, status_time,'2023-01-01 00:00:00') else TIMESTAMPDIFF(second, '2023-01-01 00:00:00',status_time) end)/3600/24) as total_uptime_days
from Servers
