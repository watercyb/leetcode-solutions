/*
 * Problem: 2494. Merge Overlapping Events in the Same Hall
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/merge-overlapping-events-in-the-same-hall/
 * Language: mysql
 * Date: 2026-04-27
 */

# Write your MySQL query statement below
with rnk as (
    select *, ROW_NUMBER() over (partition by hall_id order by start_day, end_day) as rnk
    from HallEvents
),
maxDay as (
    select *, MAX(end_day) over (partition by hall_id order by rnk) as maxDay
    from rnk
),
prv as (
    select *, LAG(maxDay) over (partition by hall_id order by rnk) as prv
    from maxDay
),
beginning as (
    select hall_id, start_day, end_day, rnk
    from prv
    where prv is null or prv<start_day
),
rng as (
    select *, IFNULL(LEAD(rnk) over (partition by hall_id order by rnk), 10000) as next
    from beginning
)
select a.hall_id, a.start_day, MAX(b.end_day) as end_day
from rng as a, rnk as b
where a.hall_id=b.hall_id and a.rnk<=b.rnk and a.next>b.rnk
group by hall_id, start_day
