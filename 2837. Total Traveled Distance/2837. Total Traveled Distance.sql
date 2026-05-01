/*
 * Problem: 2837. Total Traveled Distance
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/total-traveled-distance/
 * Language: mysql
 * Date: 2026-05-01
 */

# Write your MySQL query statement below
select a.*, SUM(IFNULL(b.distance,0)) as 'traveled distance'
from Users as a
left join Rides as b
on a.user_id=b.user_id
group by user_id
order by user_id
