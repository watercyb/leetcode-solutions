/*
 * Problem: 3140. Consecutive Available Seats II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/consecutive-available-seats-ii/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with one as (
    select seat_id
    from Cinema
    where free=1
),
r as (
    select seat_id, seat_id-ROW_NUMBER() over (order by seat_id) as r
    from one
),
grp as (
    select MIN(seat_id) as id, COUNT(*) as cnt
    from r
    group by r
),
rnk as (
    select id, cnt, RANK() over (order by cnt desc) as r
    from grp
)
select id as first_seat_id, id+cnt-1 as last_seat_id, cnt as consecutive_seats_len
from rnk
where r=1
order by first_seat_id
