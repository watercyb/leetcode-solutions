/*
 * Problem: 1050. Actors and Directors Who Cooperated At Least Three Times
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/
 * Language: mysql
 * Date: 2026-04-11
 */

# Write your MySQL query statement below
select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having COUNT(*)>=3
