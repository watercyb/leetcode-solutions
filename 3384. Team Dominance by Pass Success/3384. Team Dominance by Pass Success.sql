/*
 * Problem: 3384. Team Dominance by Pass Success
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/team-dominance-by-pass-success/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
with total as (select b.team_name, case when a.time_stamp<='45:00' then 1 else 2 end as half_number, case when b.team_name=c.team_name then 1 else -1 end as dominance
from Passes as a, Teams as b, Teams as c
where a.pass_from=b.player_id and a.pass_to=c.player_id)
select team_name, half_number, SUM(dominance) as dominance
from total
group by team_name, half_number
order by team_name, half_number
