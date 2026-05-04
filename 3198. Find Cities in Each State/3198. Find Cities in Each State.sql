/*
 * Problem: 3198. Find Cities in Each State
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-cities-in-each-state/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
select state, GROUP_CONCAT(city order by city SEPARATOR ', ') as cities
from cities
group by state
