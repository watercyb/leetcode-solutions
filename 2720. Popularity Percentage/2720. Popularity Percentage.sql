/*
 * Problem: 2720. Popularity Percentage
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/popularity-percentage/
 * Language: mysql
 * Date: 2026-04-30
 */

# Write your MySQL query statement below
with un as (
    select *
    from Friends
    union all
    select user2, user1
    from Friends
),
cnt as (
    select user1, COUNT(distinct user2) as cnt
    from un
    group by user1
),
total as (
    select COUNT(distinct user1) as total
    from un
)
select user1, ROUND(cnt/(select total from total)*100,2) as percentage_popularity
from cnt
order by user1
