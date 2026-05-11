/*
 * Problem: 3808. Find Emotionally Consistent Users
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-emotionally-consistent-users/
 * Language: mysql
 * Date: 2026-05-11
 */

# Write your MySQL query statement below
With t1 as (
    select user_id
    from reactions
    group by user_id
    having COUNT(distinct content_id)>=5
),
t2 as (
    select b.*
    from t1 as a
    left join reactions as b
    on a.user_id=b.user_id
),
t3 as (
    select user_id, reaction, COUNT(reaction) as cnt
    from t2
    group by user_id, reaction
),
t4 as (
    select user_id, reaction as dominant_reaction, ROUND(cnt/(SUM(cnt) over (partition by user_id)),2) as reaction_ratio 
    from t3
    order by reaction_ratio desc, user_id
)
select *
from t4
where reaction_ratio>=0.6
