/*
 * Problem: 603. Consecutive Available Seats
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/consecutive-available-seats/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select distinct a.seat_id
from Cinema as a, Cinema as b
where a.free=1 and b.free=1 and (a.seat_id=b.seat_id+1 or a.seat_id=b.seat_id-1)
