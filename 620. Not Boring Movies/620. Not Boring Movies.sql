/*
 * Problem: 620. Not Boring Movies
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/not-boring-movies/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select *
from Cinema
where id%2=1 and description!='boring'
order by rating desc
