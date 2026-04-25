/*
 * Problem: 2298. Tasks Count in the Weekend
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/tasks-count-in-the-weekend/
 * Language: mysql
 * Date: 2026-04-25
 */

# Write your MySQL query statement below
select SUM(case when WEEKDAY(submit_date)>=5 then 1 else 0 end) as weekend_cnt, SUM(case when WEEKDAY(submit_date)<5 then 1 else 0 end) as working_cnt
from Tasks
