/*
 * Problem: 3601. Find Drivers with Improved Fuel Efficiency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-drivers-with-improved-fuel-efficiency/
 * Language: mysql
 * Date: 2026-05-09
 */

# Write your MySQL query statement below
with l as (
    select driver_id, AVG(distance_km/fuel_consumed) as first_half_avg
    from trips
    where MONTH(trip_date)<=6
    group by driver_id
),
r as (
    select driver_id, AVG(distance_km/fuel_consumed) as second_half_avg
    from trips
    where MONTH(trip_date)>6
    group by driver_id
),
cmb as (
    select a.driver_id, ROUND(a.first_half_avg,2) as first_half_avg, ROUND(b.second_half_avg,2) as second_half_avg, ROUND(b.second_half_avg- a.first_half_avg,2) as efficiency_improvement
    from l as a, r as b
    where a.driver_id=b.driver_id
    having efficiency_improvement>0
)
select b.driver_id, a.driver_name, b.first_half_avg, b.second_half_avg, b.efficiency_improvement
from drivers as a, cmb as b
where a.driver_id=b.driver_id
order by efficiency_improvement desc, driver_name
