/*
 * Problem: 2112. The Airport With the Most Traffic
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-airport-with-the-most-traffic/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with cnt as (select departure_airport as airport_id, SUM(flights_count) as cnt
from Flights
group by departure_airport
union all
select arrival_airport as airport_id, SUM(flights_count) as cnt
from Flights
group by arrival_airport),
r as (select airport_id, RANK() over (order by SUM(cnt) desc) as r
from cnt
group by airport_id)
select airport_id
from r
where r=1
