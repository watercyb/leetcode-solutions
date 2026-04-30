/*
 * Problem: 2783. Flight Occupancy and Waitlist Analysis
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flight-occupancy-and-waitlist-analysis/
 * Language: mysql
 * Date: 2026-04-30
 */

# Write your MySQL query statement below
with p as (
    select flight_id, COUNT(*) as cnt
    from Passengers
    group by flight_id
)
select a.flight_id, IFNULL(LEAST(b.cnt, a.capacity),0) as booked_cnt, IFNULL(GREATEST(b.cnt-a.capacity, 0),0) as waitlist_cnt
from Flights as a
left join p as b
on a.flight_id=b.flight_id
order by flight_id
