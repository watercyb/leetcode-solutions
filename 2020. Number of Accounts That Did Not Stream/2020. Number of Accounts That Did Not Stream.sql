/*
 * Problem: 2020. Number of Accounts That Did Not Stream
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-accounts-that-did-not-stream/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
with sub as (select distinct account_id
from Subscriptions
where start_date<='2021-12-31' and end_date>='2021-01-01'),
cnt as (select a.account_id, COUNT(b.session_id) as cnt
from sub as a
left join Streams as b
on a.account_id=b.account_id and YEAR(b.stream_date)='2021'
group by account_id)
select COUNT(*) as accounts_count
from cnt
where cnt=0
