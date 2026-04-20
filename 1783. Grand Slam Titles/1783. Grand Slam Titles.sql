/*
 * Problem: 1783. Grand Slam Titles
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/grand-slam-titles/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select a.player_id, a.player_name, SUM(case when b.Wimbledon=a.player_id then 1 else 0 end)+SUM(case when b.Fr_open=a.player_id then 1 else 0 end)+SUM(case when b.US_open=a.player_id then 1 else 0 end)+SUM(case when b.Au_open=a.player_id then 1 else 0 end) as grand_slams_count
from Players as a, Championships as b
group by a.player_id
having grand_slams_count>0
