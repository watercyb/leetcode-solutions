/*
 * Problem: 2793. Status of Flight Tickets
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/status-of-flight-tickets/
 * Language: mysql
 * Date: 2026-04-30
 */

# Write your MySQL query statement below
with cnt as (
    select passenger_id, flight_id, COUNT(*) over (partition by flight_id order by booking_time) as cnt
    from Passengers
),
cmb as (
    select a.*, b.capacity
    from cnt as a, Flights as b
    where a.flight_id=b.flight_id
)
select passenger_id, case when cnt>capacity then 'Waitlist' else 'Confirmed' end as Status
from cmb
order by passenger_id
