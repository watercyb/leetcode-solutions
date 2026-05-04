/*
 * Problem: 3103. Find Trending Hashtags II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-trending-hashtags-ii/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with recursive rng as (
	select tweet, LENGTH(tweet) - LENGTH(REPLACE(tweet, '#', '')) as n
    from Tweets
    where DATE_FORMAT(tweet_date,'%Y%m')='202402'
),
rec as (
    select SUBSTRING_INDEX(SUBSTRING_INDEX(SUBSTRING_INDEX(tweet, '#', 2), '#', -1), ' ', 1) as str, tweet , 1 as c, n
    from rng
    where n>=1
    union all
    select SUBSTRING_INDEX(SUBSTRING_INDEX(SUBSTRING_INDEX(tweet, '#', c+2), '#', -1), ' ', 1) as str, tweet, c+1 as c, n
    from rec
    where c<n
)
select CONCAT('#',str) as hashtag, COUNT(*) as 'count'
from rec
group by str
order by count desc, hashtag desc
limit 3
