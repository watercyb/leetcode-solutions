/*
 * Problem: 2989. Class Performance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/class-performance/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
select MAX(assignment1+assignment2+assignment3)-MIN(assignment1+assignment2+assignment3) as difference_in_score
from Scores
