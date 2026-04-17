/*
 * Problem: 1407. Top Travellers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/top-travellers/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select a.name, IFNULL(SUM(b.distance),0) as travelled_distance
from Users as a
left join Rides as b
on a.id=b.user_id
group by a.id
order by travelled_distance desc, name
