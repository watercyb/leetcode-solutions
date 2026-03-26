/*
 * Problem: 197. Rising Temperature
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rising-temperature/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select a.id
from Weather as a, Weather as b
where a.recordDate - interval 1 day=b.recordDate and a.temperature > b.temperature
