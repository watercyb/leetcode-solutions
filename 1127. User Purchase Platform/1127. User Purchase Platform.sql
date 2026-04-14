/*
 * Problem: 1127. User Purchase Platform
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/user-purchase-platform/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
with types as (select spend_date, SUM(amount) as total_amount, COUNT(distinct user_id) as total_users, type
from
(select user_id, spend_date, SUM(amount) as amount, SUM(case when platform='mobile' then 1 else 10 end) as type
from Spending
group by user_id, spend_date) as a
group by spend_date, type),
alltypes as (select distinct spend_date, 'mobile' as platform, 1 as type from Spending
union
select distinct spend_date, 'desktop' as platfrom, 10 as type from Spending
union
select distinct spend_date, 'both' as platfrom, 11 as type from Spending)
select a.spend_date, a.platform, IFNULL(b.total_amount,0) as total_amount, IFNULL(b.total_users,0) as total_users
from alltypes as a
left join types as b
on a.spend_date=b.spend_date and a.type=b.type
