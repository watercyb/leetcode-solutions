/*
 * Problem: 574. Winning Candidate
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/winning-candidate/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select a.name
from Candidate as a, Vote as b
where a.id=b.candidateId
group by a.id
order by COUNT(*) desc
limit 1
