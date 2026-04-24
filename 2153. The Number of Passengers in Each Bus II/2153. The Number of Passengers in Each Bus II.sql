/*
 * Problem: 2153. The Number of Passengers in Each Bus II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-number-of-passengers-in-each-bus-ii/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with recursive re as (
    with busRange as (select *, LAG(arrival_time,1,0) over (order by arrival_time) as prv
    from Buses),
    passengerCount as (select a.*, COUNT(b.passenger_id) as s1, ROW_NUMBER() over (order by a.arrival_time) as r
    from busRange as a
    left join Passengers as b
    on b.arrival_time<=a.arrival_time and b.arrival_time>a.prv
    group by a.bus_id)
    select bus_id, LEAST(s1, capacity) as passengers_cnt, GREATEST(s1-capacity,0) as s, r
    from passengerCount
    where r=1
    union
    select b.bus_id, LEAST(b.s1+a.s, b.capacity) as passengers_cnt, GREATEST(b.s1+a.s-b.capacity,0) as s, b.r
    from re as a, passengerCount as b
    where a.r+1=b.r
)
select bus_id, passengers_cnt
from re
order by bus_id
