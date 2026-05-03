/*
 * Problem: 3056. Snaps Analysis
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/snaps-analysis/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with total as (
    select a.age_bucket, 
        SUM(case when b.activity_type='open' then time_spent else 0 end) as open, 
        SUM(case when b.activity_type='send' then time_spent else 0 end) as send
    from Age as a
    left join Activities as b
    on a.user_id=b.user_id
    group by age_bucket
)
select age_bucket, 
    ROUND(send/(send+open)*100,2) as send_perc, 
    ROUND(open/(send+open)*100,2) as open_perc
from total
