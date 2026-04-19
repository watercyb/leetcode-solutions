/*
 * Problem: 1635. Hopper Company Queries I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/hopper-company-queries-i/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
with recursive b1 as (select 1 as month, 0
union all
select month+1 as month, 0
from b1
where month<12),
a as (select driver_id, (case when join_date<'2020-01-01' then '2020-01-01' else join_date end) as join_date
from Drivers
where join_date<'2021-01-01'),
b as (select distinct CONVERT(DATE_FORMAT(join_date,"%m"),unsigned) as month, COUNT(driver_id) over (partition by DATE_FORMAT(join_date,"%m")) as count
from a
union all
select *
from b1),
c as (select month, SUM(count) as count
from b
group by month),
d as (select month, SUM(count) over (order by month) as active_drivers
from c),
e as (select CONVERT(DATE_FORMAT(requested_at,"%m"),unsigned) as month, COUNT(*) as accepted_rides
from Rides
where requested_at>='2020-01-01' and requested_at<'2021-01-01' and ride_id in (select ride_id from AcceptedRides)
group by month)
select a.*, IFNULL(b.accepted_rides,0) as accepted_rides`
from d as a
left join e as b
on a.month=b.month
