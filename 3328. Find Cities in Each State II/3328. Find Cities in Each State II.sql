/*
 * Problem: 3328. Find Cities in Each State II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-cities-in-each-state-ii/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-02
 */

# Write your MySQL query statement below
select state, GROUP_CONCAT(city  order by city SEPARATOR ', ') as cities, SUM(case when LEFT(city,1)=LEFT(state,1) then 1 else 0 end) as matching_letter_count
from cities
group by state
having COUNT(*)>=3 and matching_letter_count>0
order by matching_letter_count desc, state
