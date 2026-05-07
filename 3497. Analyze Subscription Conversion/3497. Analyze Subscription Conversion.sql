/*
 * Problem: 3497. Analyze Subscription Conversion
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/analyze-subscription-conversion/
 * Language: mysql
 * Date: 2026-05-07
 */

# Write your MySQL query statement below
with tab as (
    select user_id, SUM(case when activity_type='free_trial' then activity_duration else 0 end) as f, SUM(case when activity_type='free_trial' then 1 else 0 end) as fc, SUM(case when activity_type='paid' then activity_duration else 0 end) as a, SUM(case when activity_type='paid' then 1 else 0 end) as ac
    from UserActivity
    group by user_id
    having ac>0
)
select user_id, ROUND(f/fc,2) as trial_avg_duration, ROUND(a/ac,2) as paid_avg_duration
from tab
order by user_id
