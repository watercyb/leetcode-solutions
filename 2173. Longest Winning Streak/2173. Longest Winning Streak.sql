/*
 * Problem: 2173. Longest Winning Streak
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-winning-streak/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with r as (select *,
    Rank() over (partition by player_id order by match_day)-
    Rank() over (partition by player_id, result order by match_day) r
from Matches),
num as (select player_id, COUNT(r) as num
from r
where result='Win'
group by player_id, r)
select a.player_id, IFNULL(MAX(num.num),0) as longest_streak
from (select distinct player_id from Matches) as a
left join num
on a.player_id=num.player_id
group by a.player_id
