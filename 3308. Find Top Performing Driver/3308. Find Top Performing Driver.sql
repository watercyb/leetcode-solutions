/*
 * Problem: 3308. Find Top Performing Driver
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-top-performing-driver/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
with total as (select a.driver_id, a.accidents, b.fuel_type, SUM(c.distance) as distance, ROUND(AVG(rating),2) as rating
from Drivers as a, Vehicles as b, Trips as c
where a.driver_id=b.driver_id and b.vehicle_id=c.vehicle_id
group by driver_id, fuel_type),
r as (select fuel_type, driver_id, rating, distance, RANK() over (partition by fuel_type order by rating desc, distance desc, accidents) as r
from total)
select fuel_type, driver_id, rating, distance
from r
where r=1
