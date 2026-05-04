/*
 * Problem: 3166. Calculate Parking Fees and Duration
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/calculate-parking-fees-and-duration/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with t as (
    select lot_id, car_id, TIMESTAMPDIFF(minute, entry_time, exit_time) as t, fee_paid
    from ParkingTransactions
),
s as (
    select lot_id, car_id, SUM(t) as t
    from t
    group by lot_id, car_id
),
r as (
    select lot_id, car_id, ROW_NUMBER() over (partition by car_id order by t desc) as r
    from s
),
r1 as (
    select car_id, lot_id
    from r
    where r=1
),
t1 as (
    select car_id, SUM(t/60) as t, SUM(fee_paid) as p
    from t
    group by car_id
)
select a.car_id, a.p as total_fee_paid, ROUND(a.p/a.t,2) as avg_hourly_fee, b.lot_id as most_time_lot
from t1 as a, r1 as b
where a.car_id=b.car_id
