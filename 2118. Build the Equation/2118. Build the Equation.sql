/*
 * Problem: 2118. Build the Equation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/build-the-equation/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with a as (select GROUP_CONCAT(CONCAT(
    (case when factor<0 then factor else CONCAT('+', factor) end),
    (case when power>1 then CONCAT('X^', power) when power=1 then 'X' else '' end)
)  order by power desc separator '') as equation
from Terms)
select CONCAT(equation, '=0') equation
from a
