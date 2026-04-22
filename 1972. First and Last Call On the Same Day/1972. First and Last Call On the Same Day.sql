/*
 * Problem: 1972. First and Last Call On the Same Day
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/first-and-last-call-on-the-same-day/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
with total as (select *
from Calls
union all
select recipient_id, caller_id, call_time
from Calls),
dayAndTime as (select caller_id, recipient_id, DATE_FORMAT(call_time,'%Y-%m-%d') as day, DATE_FORMAT(call_time,'%H:%m:%s') as time
from total),
rnk as (select caller_id, recipient_id, day, RANK() over (partition by caller_id, day order by time) as r , RANK() over (partition by caller_id, day order by time desc) as r1
from dayAndTime),
rnk1 as (select *
from rnk
where r=1 or r1=1)
select distinct a.caller_id as user_id
from rnk1 as a, rnk1 as b
where a.r=1 and b.r1=1 and a.caller_id=b.caller_id and a.recipient_id=b.recipient_id and a.day=b.day
