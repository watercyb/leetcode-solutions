/*
 * Problem: 2688. Find Active Users
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-active-users/
 * Language: mysql
 * Date: 2026-04-29
 */

# Write your MySQL query statement below
with prv as (
    select user_id, created_at, LAG(created_at) over (partition by user_id order by created_at) as prv
    from Users
)
select distinct user_id
from prv
where DATEDIFF(created_at, prv)<=7
