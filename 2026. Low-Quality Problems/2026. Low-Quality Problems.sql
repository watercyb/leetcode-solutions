/*
 * Problem: 2026. Low-Quality Problems
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/low-quality-problems/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
select problem_id
from Problems
where likes/dislikes<1.5
order by problem_id
