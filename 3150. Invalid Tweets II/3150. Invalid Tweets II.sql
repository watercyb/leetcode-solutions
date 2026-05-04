/*
 * Problem: 3150. Invalid Tweets II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/invalid-tweets-ii/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
select tweet_id
from Tweets
where LENGTH(content)>=140 or LENGTH(content)-LENGTH(REPLACE(content, '@', ''))>3 or LENGTH(content)-LENGTH(REPLACE(content, '#', ''))>3
