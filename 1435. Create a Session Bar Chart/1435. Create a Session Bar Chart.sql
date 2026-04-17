/*
 * Problem: 1435. Create a Session Bar Chart
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/create-a-session-bar-chart/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select bin, SUM(total) as total
from
(select '[0-5>' as bin, 0 as total
union
select '[5-10>' as bin, 0 as total
union
select '[10-15>' as bin, 0 as total
union
select '15 or more' as bin, 0 as total
union
select bin, COUNT(session_id) as total
from
(select session_id, (case when duration/60<5 then '[0-5>' when duration/60<10 then '[5-10>' when duration/60<15 then '[10-15>' else '15 or more' end) as bin
from Sessions) as a
group by bin) as a
group by bin
