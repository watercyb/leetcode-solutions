/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-circular-gift-exchange-chains/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-09
 */

# Write your MySQL query statement below
with recursive start as (
    select *, ROW_NUMBER() over (order by giver_id) as r, giver_id as start
    from SecretSanta
),
rec as (
    select *
    from start
    union all
    select a.giver_id, a.receiver_id, a.gift_value, b.r, b.start
    from start as a, rec as b 
    where a.giver_id=b.receiver_id and a.giver_id!=b.start
),
chk as (
    select GROUP_CONCAT(giver_id order by giver_id separator '_') as giver, GROUP_CONCAT(receiver_id order by receiver_id separator '_') as receiver, r
    from rec
    group by r
    having giver=receiver
),
grp as (
    select giver_id, receiver_id, gift_value, MIN(r) as r
    from rec
    where r in (select r from chk)
    group by giver_id, receiver_id
),
cnt as (
    select distinct COUNT(*) as chain_length, SUM(gift_value) as total_gift_value
    from grp
    group by r
)
select ROW_NUMBER() over (order by chain_length desc, total_gift_value desc) as chain_id, chain_length, total_gift_value
from cnt
# select ROW_NUMBER() over (order by SUM(gift_value) desc) as chain_id, COUNT(*) as chain_length, SUM(gift_value) as total_gift_value
# from grp
# group by r
# order by total_gift_value desc
