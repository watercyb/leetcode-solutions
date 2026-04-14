/*
 * Problem: 1194. Tournament Winners
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/tournament-winners/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
with score as (select a.group_id, a.player_id, SUM(b.score) as score
from Players as a,
(select first_player as player, SUM(first_score) as score
from Matches
group by first_player
union all
select second_player as player, SUM(second_score) as score
from Matches
group by second_player) as b
where a.player_id=b.player
group by player_id),
r as (select *, RANK() over (partition by group_id order by score desc, player_id) as r
from score)
select group_id, player_id
from r
where r=1
