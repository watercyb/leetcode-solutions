/*
 * Problem: 1107. New Users Daily Count
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/new-users-daily-count/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select date as login_date, COUNT(*) as user_count
from
(select user_id, MIN(activity_date) as date
from Traffic
where activity='login'
group by user_id
having date>='2019-06-30'-interval 90 day) as a
group by login_date
