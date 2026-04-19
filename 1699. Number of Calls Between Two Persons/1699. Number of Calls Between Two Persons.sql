/*
 * Problem: 1699. Number of Calls Between Two Persons
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-calls-between-two-persons/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select LEAST(from_id, to_id) as person1, GREATEST(from_id, to_id) as person2, COUNT(*) as call_count, SUM(duration) as total_duration
from Calls
group by person1, person2
