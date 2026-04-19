/*
 * Problem: 1613. Find the Missing IDs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-missing-ids/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
with recursive num as (
    select 1 as num
    union
    select num + 1
    from num
    where num < (select MAX(customer_id) from Customers)
)
select num as ids
from num 
where num not in (select customer_id from Customers)
