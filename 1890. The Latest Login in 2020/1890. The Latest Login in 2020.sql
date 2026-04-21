/*
 * Problem: 1890. The Latest Login in 2020
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-latest-login-in-2020/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select user_id, MAX(time_stamp) as last_stamp
from Logins
where YEAR(time_stamp)='2020'
group by user_id
