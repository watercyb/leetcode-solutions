/*
 * Problem: 1809. Ad-Free Sessions
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/ad-free-sessions/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select a.session_id
from Playback as a
left join Ads as b
on a.customer_id=b.customer_id and a.start_time<=b.timestamp and a.end_time>=timestamp
where b.ad_id is null
