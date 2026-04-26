/*
 * Problem: 2314. The First Day of the Maximum Recorded Degree in Each City
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-first-day-of-the-maximum-recorded-degree-in-each-city/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with r as (select *, RANK() over (partition by city_id order by degree desc, day) as r
from Weather)
select city_id, day, degree
from r
where r=1
