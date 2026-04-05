/*
 * Problem: 610. Triangle Judgement
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/triangle-judgement/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select *, case when (x>=y and x>=z and x<y+z) or (y>=x and y>=z and y<x+z) or (z>=x and z>=y and z<x+y) then 'Yes' else 'No' end as triangle
from Triangle
