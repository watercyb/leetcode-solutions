/*
 * Problem: 1308. Running Total for Different Genders
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/running-total-for-different-genders/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select gender, day, SUM(total) over (partition by gender order by gender, day) as total
from 
(select gender, day, SUM(score_points) as total
from Scores
group by gender, day
order by gender, day) as a
