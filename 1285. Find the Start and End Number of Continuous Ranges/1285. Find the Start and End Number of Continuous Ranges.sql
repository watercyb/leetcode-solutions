/*
 * Problem: 1285. Find the Start and End Number of Continuous Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-start-and-end-number-of-continuous-ranges/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select MIN(log_id) as start_id, MAX(log_id) as end_id
from
(select log_id, log_id - ROW_NUMBER() over (order by log_id) as g
from Logs) as a
group by g
