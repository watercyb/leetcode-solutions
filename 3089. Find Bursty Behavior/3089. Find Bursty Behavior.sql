/*
 * Problem: 3089. Find Bursty Behavior
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-bursty-behavior/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with rng as (
    select *
    from Posts
    where post_date>='20240201' and post_date<='20240228'
),
av as (
    select user_id, COUNT(*)/4 as avg_weekly_posts
    from rng
    group by user_id
),
cnt as (
    select a.user_id, COUNT(b.post_date) as cnt
    from rng as a, rng as b
    where a.user_id=b.user_id and a.post_date>=b.post_date and b.post_date+interval 7 day>a.post_date
    group by a.post_id
),
mx as (
    select user_id, MAX(cnt) as mx
    from cnt
    group by user_id
)
select a.user_id, b.mx as max_7day_posts, a.avg_weekly_posts
from av as a, mx as b
where a.user_id=b.user_id and b.mx >=2*a.avg_weekly_posts
order by user_id
