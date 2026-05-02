/*
 * Problem: 2984. Find Peak Calling Hours for Each City
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-peak-calling-hours-for-each-city/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with rnk as (
    select city, CAST(DATE_FORMAT(call_time, '%H') as unsigned) as m, COUNT(*) as cnt, RANK() over (partition by city order by COUNT(*) desc) as r
    from Calls
    group by city, m
)
select city, m as peak_calling_hour, cnt as number_of_calls
from rnk
where r=1
order by peak_calling_hour desc, city desc
