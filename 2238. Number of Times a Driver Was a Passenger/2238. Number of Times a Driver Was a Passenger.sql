/*
 * Problem: 2238. Number of Times a Driver Was a Passenger
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-times-a-driver-was-a-passenger/
 * Language: mysql
 * Date: 2026-04-25
 */

# Write your MySQL query statement below
select a.driver_id, COUNT(b.passenger_id) as cnt
from (select distinct driver_id from Rides) as a
left join Rides as b
on a.driver_id=b.passenger_id
group by a.driver_id
