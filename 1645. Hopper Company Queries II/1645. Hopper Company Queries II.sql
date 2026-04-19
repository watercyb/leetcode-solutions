/*
 * Problem: 1645. Hopper Company Queries II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/hopper-company-queries-ii/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
with a as(select CONVERT(DATE_FORMAT(a.requested_at,'%m'),unsigned) as month, COUNT(distinct b.driver_id) as num
from Rides as a, AcceptedRides as b
where a.ride_id=b.ride_id and requested_at>='2020-01-01' and requested_at<'2021-01-01'
group by month),
b as (select (case when join_date<'2020-01-01' then '2020-01-01' else join_date end) as month
from Drivers
where join_date<'2021-01-01'),
d as (select CONVERT(DATE_FORMAT(month,'%m'),unsigned) as month, COUNT(*) as num
from b
group by CONVERT(DATE_FORMAT(month,'%m'),unsigned)
union all
(with recursive c as (select 1 as month, 0 as num
union all
select month+1 as month, num
from c
where month<12)
select *
from c)),
e as (select month, SUM(num) over (order by month) as num
from d
group by month)
select b.month as month, IFNULL(ROUND(a.num/b.num*100,2),0) as working_percentage
from e as b
left join a as a
on a.month=b.month
