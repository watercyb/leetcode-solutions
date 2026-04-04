/*
 * Problem: 597. Friend Requests I: Overall Acceptance Rate
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select IFNULL(ROUND(
    (select COUNT(distinct requester_id, accepter_id) from RequestAccepted)/
    (select COUNT(distinct sender_id, send_to_id) from FriendRequest)
    ,2),0) as accept_rate
