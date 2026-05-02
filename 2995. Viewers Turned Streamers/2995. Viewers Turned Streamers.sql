/*
 * Problem: 2995. Viewers Turned Streamers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/viewers-turned-streamers/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
select user_id, COUNT(*) as sessions_count
from Sessions
where user_id in (select user_id
from
(select user_id, session_type, ROW_NUMBER() over (partition by user_id order by session_start) as r
from Sessions) as a
where session_type='Viewer' and r=1) and session_type='streamer'
group by user_id
order by sessions_count desc, user_id desc
