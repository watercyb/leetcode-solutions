/*
 * Problem: 3087. Find Trending Hashtags
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-trending-hashtags/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with h as (
    select user_id, CONCAT('#',SUBSTRING_INDEX(SUBSTRING_INDEX(tweet, '#', -1), ' ', 1)) as h
    from Tweets
    where DATE_FORMAT(tweet_date, '%Y-%m')='2024-02'
)
select h as HASHTAG, COUNT(*) as HASHTAG_COUNT
from h
group by h
order by HASHTAG_COUNT desc, HASHTAG desc
limit 3
