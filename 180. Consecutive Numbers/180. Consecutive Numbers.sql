/*
 * Problem: 180. Consecutive Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/consecutive-numbers/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select distinct a.num as ConsecutiveNums
from Logs as a, Logs as b, Logs as c
where a.num=b.num and b.num=c.num and a.id+1=b.id and b.id+1=c.id
