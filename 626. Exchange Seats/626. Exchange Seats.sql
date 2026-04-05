/*
 * Problem: 626. Exchange Seats
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/exchange-seats/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select rank() over (order by ((id+1)^1)-1) as id, student
from Seat
