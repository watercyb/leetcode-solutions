/*
 * Problem: 2820. Election Results
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/election-results/
 * Language: mysql
 * Date: 2026-05-01
 */

# Write your MySQL query statement below
with r as (select voter, COUNT(*) as s
from Votes
group by voter),
r1 as (select a.voter, a.candidate, RANK() over (order by SUM(1/b.s) desc) as r
from Votes as a, r as b
where a.candidate is not null and a.voter=b.voter
group by a.candidate)
select candidate
from r1
where r=1
order by candidate
