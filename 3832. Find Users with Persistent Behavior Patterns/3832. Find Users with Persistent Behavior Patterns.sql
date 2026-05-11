/*
 * Problem: 3832. Find Users with Persistent Behavior Patterns
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-users-with-persistent-behavior-patterns/
 * Language: mysql
 * Date: 2026-05-11
 */

# Write your MySQL query statement below
with t1 as (
    select user_id, action_date, action
    from activity
    group by user_id, action_date
    having COUNT(*)=1
),
t2 as (
    select user_id, action_date, action, action_date-ROW_NUMBER() over (partition by user_id, action order by action_date) as r
    from t1
)
select user_id, action, COUNT(*) as streak_length, MIN(action_date) as start_date, MAX(action_date) as end_date
from t2
group by user_id, action, r
having streak_length>=5
order by streak_length desc, user_id
