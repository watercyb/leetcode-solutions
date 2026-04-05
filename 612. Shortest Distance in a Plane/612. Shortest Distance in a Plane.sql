/*
 * Problem: 612. Shortest Distance in a Plane
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-distance-in-a-plane/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
with P2D as (
    select *, ROW_NUMBER() over () as r
    from Point2D
)
select ROUND(SQRT((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)),2) as shortest
from P2D as a, P2D as b
where a.r<b.r
order by shortest
limit 1
