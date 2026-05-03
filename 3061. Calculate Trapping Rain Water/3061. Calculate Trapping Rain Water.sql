/*
 * Problem: 3061. Calculate Trapping Rain Water
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/calculate-trapping-rain-water/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with diff as (
    select LEAST(MAX(b.height),MAX(c.height))-a.height as h
    from Heights as a
    join Heights as b
    on a.id>b.id and a.height<b.height
    join Heights as c
    on a.id<c.id and a.height<c.height
    group by a.id
)
select IFNULL(SUM(h),0) as total_trapped_water
from diff
