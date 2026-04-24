/*
 * Problem: 2142. The Number of Passengers in Each Bus I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-number-of-passengers-in-each-bus-i/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with a as (select a.passenger_id, MIN(b.arrival_time*10000+b.bus_id) as min
from Passengers as a, Buses as b
where a.arrival_time<=b.arrival_time
group by a.passenger_id),
b as (select min%10000 as bus_id, COUNT(*) as passengers_cnt
from a
group by bus_id)
select a.bus_id, IFNULL(b.passengers_cnt,0) as passengers_cnt
from Buses as a
left join b as b
on a.bus_id=b.bus_id
order by bus_id
