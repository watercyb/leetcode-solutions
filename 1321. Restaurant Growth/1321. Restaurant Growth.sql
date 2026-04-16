/*
 * Problem: 1321. Restaurant Growth
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/restaurant-growth/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select a.visited_on, SUM(b.amount) as amount, ROUND(SUM(b.amount)/7,2) as average_amount
from
(select visited_on, SUM(amount) from Customer group by visited_on) as a,
Customer as b
where a.visited_on>=b.visited_on and a.visited_on - INTERVAL 6 DAY<=b.visited_on
group by visited_on
having a.visited_on>= MIN(b.visited_on)+INTERVAL 6 DAY
