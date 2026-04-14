/*
 * Problem: 1113. Reported Posts
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reported-posts/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select extra as report_reason, COUNT(distinct post_id) report_count
from Actions
where action_date='2019-07-04' and action='report'
group by extra
