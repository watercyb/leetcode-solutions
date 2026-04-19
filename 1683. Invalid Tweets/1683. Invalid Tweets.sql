/*
 * Problem: 1683. Invalid Tweets
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/invalid-tweets/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select tweet_id
from Tweets
where LENGTH(content)>15
