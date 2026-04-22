/*
 * Problem: 1939. Users That Actively Request Confirmation Messages
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/users-that-actively-request-confirmation-messages/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
select distinct a.user_id
from Confirmations as a, Confirmations as b
where a.user_id=b.user_id and a.time_stamp<b.time_stamp and DATE_ADD(a.time_stamp, interval 24 hour) >= b.time_stamp
