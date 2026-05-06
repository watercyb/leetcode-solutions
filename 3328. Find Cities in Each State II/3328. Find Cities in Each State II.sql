/*
 * Problem: 3328. Find Cities in Each State II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-cities-in-each-state-ii/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
select state, GROUP_CONCAT(city  order by city SEPARATOR ', ') as cities, SUM(case when LEFT(city,1)=LEFT(state,1) then 1 else 0 end) as matching_letter_count
from cities
group by state
having COUNT(*)>=3 and matching_letter_count>0
order by matching_letter_count desc, state
