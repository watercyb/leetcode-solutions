/*
 * Problem: 3058. Friends With No Mutual Friends
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/friends-with-no-mutual-friends/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with total as (
    select *
    from Friends
    union all
    select user_id2, user_id1
    from Friends
),
cmf as (
    select distinct a.user_id1, b.user_id2
    from total as a, total as b
    where a.user_id2=b.user_id1 and a.user_id1!=b.user_id2
)
select *
from Friends
where not exists (
    select *
    from cmf
    where Friends.user_id1=cmf.user_id1 and Friends.user_id2=cmf.user_id2
)
order by user_id1, user_id2
