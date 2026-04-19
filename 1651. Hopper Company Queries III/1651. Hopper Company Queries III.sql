/*
 * Problem: 1651. Hopper Company Queries III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/hopper-company-queries-iii/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
with a as (select CONVERT(DATE_FORMAT(a.requested_at,'%m'),unsigned) as month, b.ride_distance, b.ride_duration
from Rides as a, AcceptedRides as b
where a.ride_id=b.ride_id and a.requested_at>='2020-01-01' and a.requested_at<'2021-01-01'
union all
(with recursive a as (select 1 as month, 0 as ride_distance, 0 as ride_duration
union all
select month+1 as month, 0 as ride_distance, 0 as ride_duration
from a
where month<12)
select * from a)),
b as (select month, SUM(ride_distance) as ride_distance, SUM(ride_duration) as ride_duration
from a
group by month)
select a.month, ROUND((a.ride_distance+b.ride_distance+c.ride_distance)/3,2) as average_ride_distance,
ROUND((a.ride_duration+b.ride_duration+c.ride_duration)/3,2) as average_ride_duration
from b as a, b as b, b as c
where a.month+1=b.month and b.month+1=c.month
group by a.month
order by a.month
