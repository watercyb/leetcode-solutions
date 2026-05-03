/*
 * Problem: 3052. Maximize Items
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-items/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with sm as (
    select SUM(case when item_type='prime_eligible' then square_footage else 0 end) as p, SUM(case when item_type='prime_eligible' then 1 else 0 end) as cnt1, SUM(case when item_type='not_prime' then square_footage else 0 end) as np, SUM(case when item_type='not_prime' then 1 else 0 end) as cnt2
    from Inventory
)
select 'prime_eligible' as item_type, FLOOR(500000/p)*cnt1 as item_count
from sm
union all
select 'not_prime', FLOOR(500000%p/np)*cnt2
from sm
