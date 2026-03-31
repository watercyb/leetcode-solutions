/*
 * Problem: 262. Trips and Users
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/trips-and-users/
 * Language: mysql
 * Date: 2026-03-31
 */

# Write your MySQL query statement below
select request_at as Day, ROUND(SUM(case when status!='completed' then 1 else 0 end)/COUNT(*),2) as 'Cancellation Rate'
from Trips
where request_at>='2013-10-01' and request_at<='2013-10-03'
and client_id not in (select users_id from Users where banned='Yes' and role='client')
and driver_id not in (select users_id from Users where banned='Yes' and role='driver')
group by request_at
