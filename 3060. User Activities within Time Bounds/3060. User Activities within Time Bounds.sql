/*
 * Problem: 3060. User Activities within Time Bounds
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/user-activities-within-time-bounds/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with prv as (
    select user_id, session_start, LAG(session_end) over (partition by user_id, session_type order by session_end) as prvTime
    from Sessions
)
select distinct user_id
from prv
where prvTime+interval 12 hour>=session_start
order by user_id
