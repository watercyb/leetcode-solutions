/*
 * Problem: 1303. Find the Team Size
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-team-size/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select employee_id, COUNT(*) over (partition by team_id) as team_size
from Employee
