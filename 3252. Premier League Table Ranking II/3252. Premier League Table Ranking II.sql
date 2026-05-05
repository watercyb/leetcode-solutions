/*
 * Problem: 3252. Premier League Table Ranking II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/premier-league-table-ranking-ii/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
with r as (
    select team_name, wins*3+draws as points, RANK() over (order by wins*3+draws desc) as position
    from TeamStats
)
select *, CONCAT('Tier ', FLOOR((position-1)/(select COUNT(*) from TeamStats)/0.33)+1) as tier
from r
order by points desc, team_name
