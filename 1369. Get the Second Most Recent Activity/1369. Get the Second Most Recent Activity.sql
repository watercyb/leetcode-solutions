/*
 * Problem: 1369. Get the Second Most Recent Activity
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/get-the-second-most-recent-activity/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
with a as (select *, ROW_NUMBER() over (partition by username order by endDate desc) as r
from UserActivity),
b as (select username, activity, startDate, endDate, ROW_NUMBER() over (partition by username order by endDate) as r
from a
where r<=2)
select username, activity, startDate, endDate
from b
where r=1
