/*
 * Problem: 1459. Rectangles Area
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rectangles-area/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select a.id as p1, b.id as p2, ABS(a.x_value-b.x_value)*ABS(a.y_value-b.y_value) as area
from Points as a, Points as b
where a.id<b.id
having area>0
order by area desc, a.id, b.id
