/*
 * Problem: 1225. Report Contiguous Dates
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/report-contiguous-dates/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select period_state, MIN(date) as start_date, MAX(date) as end_date
from
(select period_state, date, date - interval (rank() over (partition by period_state order by date)) day as r
from
(select 'failed' as period_state, fail_date as 'date'
from Failed
union
select 'succeeded' as period_state, success_date as 'date'
from Succeeded) as a
where YEAR(date)='2019') as a
group by period_state, r
order by start_date
