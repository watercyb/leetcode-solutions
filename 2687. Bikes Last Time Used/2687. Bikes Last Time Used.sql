/*
 * Problem: 2687. Bikes Last Time Used
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/bikes-last-time-used/
 * Language: mysql
 * Date: 2026-04-29
 */

# Write your MySQL query statement below
select bike_number, MAX(end_time) as end_time
from Bikes
group by bike_number
order by end_time desc
