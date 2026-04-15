/*
 * Problem: 1204. Last Person to Fit in the Bus
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/last-person-to-fit-in-the-bus/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select person_name
from
(select person_name, turn, SUM(weight) over (order by turn) as sum
from Queue) as a
where sum<=1000
order by sum desc
limit 1
