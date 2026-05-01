/*
 * Problem: 2854. Rolling Average Steps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rolling-average-steps/
 * Language: mysql
 * Date: 2026-05-01
 */

# Write your MySQL query statement below
with grp as (
    select  user_id, steps_date, LAG(steps_date) over (partition by user_id order by steps_date) as prv, LEAD(steps_date) over (partition by user_id order by steps_date) as next, steps_count+LAG(steps_count) over (partition by user_id order by steps_date)+LEAD(steps_count) over (partition by user_id order by steps_date) as sm
    from Steps
)
select user_id, next as steps_date, ROUND(sm/3,2) as rolling_average
from grp
where DATEDIFF(steps_date, prv)=1 and DATEDIFF(next, steps_date)=1
order by user_id, steps_date
