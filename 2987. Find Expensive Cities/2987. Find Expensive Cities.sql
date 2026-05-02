/*
 * Problem: 2987. Find Expensive Cities
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-expensive-cities/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with a as (
    select distinct city, AVG(price) over (partition by city) as a, AVG(price) over () as b
    from Listings
)
select city
from a
where a>b
order by city
