/*
 * Problem: 602. Friend Requests II: Who Has the Most Friends
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select id, COUNT(id) as num
from
((select requester_id as id from RequestAccepted)
union all
(select accepter_id as id from RequestAccepted)) as a
group by id
order by num desc
limit 1
