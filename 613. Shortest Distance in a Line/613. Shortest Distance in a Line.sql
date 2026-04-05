/*
 * Problem: 613. Shortest Distance in a Line
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shortest-distance-in-a-line/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select IFNULL(x-lag(x) over (order by x), 1000000000) as shortest
from Point
order by shortest
limit 1
