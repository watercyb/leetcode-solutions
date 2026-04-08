/*
 * Problem: 3390. Longest Team Pass Streak
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-team-pass-streak/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-08
 */

# Write your MySQL query statement below
with rnk as (
    select a.time_stamp, b.team_name as pass_from, c.team_name as pass_to, ROW_NUMBER() over (order by time_stamp) as rT
    from Passes as a, Teams as b, Teams as c
    where a.pass_from=b.player_id and a.pass_to=c.player_id
),
rnk1 as (
    select time_stamp, pass_from, rT-ROW_NUMBER() over (partition by pass_from order by time_stamp) as r
    from rnk
    where pass_from=pass_to
),
cnt as (
    select pass_from, COUNT(*) as cnt
    from rnk1
    group by r
)
select pass_from as team_name, MAX(cnt) as longest_streak
from cnt
group by pass_from
