/*
 * Problem: 3673. Find Zombie Sessions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-zombie-sessions/
 * Language: mysql
 * Date: 2026-05-09
 */

# Write your MySQL query statement below
with t as (
    select user_id, TIMESTAMPDIFF(MINUTE, MIN(event_timestamp), MAX(event_timestamp)) as t, SUM(case when event_type='click' then 1 else 0 end) as c, SUM(case when event_type='scroll' then 1 else 0 end) as s, SUM(case when event_type='purchase' then 1 else 0 end) as p, session_id
    from app_events
    group by session_id
    having t>30 and s>=5 and c/s<0.2 and p=0
)
select session_id, user_id, t as session_duration_minutes, s as scroll_count
from t
order by scroll_count desc, session_id
