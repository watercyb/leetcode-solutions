/*
 * Problem: 1934. Confirmation Rate
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/confirmation-rate/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
select a.user_id, IFNULL(ROUND(SUM(case when b.action='confirmed' then 1 else 0 end)/COUNT(b.action),2),0) as confirmation_rate
from Signups as a
left join Confirmations as b
on a.user_id=b.user_id
group by a.user_id
