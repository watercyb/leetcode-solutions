/*
 * Problem: 595. Big Countries
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/big-countries/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select name, population, area
from World
where area>=3000000 or population>=25000000
