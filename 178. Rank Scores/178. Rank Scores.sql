/*
 * Problem: 178. Rank Scores
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rank-scores/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select score, DENSE_RANK() over (order by score desc) as 'rank'
from Scores
