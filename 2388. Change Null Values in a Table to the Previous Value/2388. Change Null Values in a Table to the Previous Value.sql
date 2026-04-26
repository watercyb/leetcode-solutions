/*
 * Problem: 2388. Change Null Values in a Table to the Previous Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/change-null-values-in-a-table-to-the-previous-value/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with r as (select *, SUM(case when drink is not null then 1 else 0 end) over (rows between unbounded preceding and current row) as r
from CoffeeShop),
drink as (
    select *
    from r
    where drink is not null
)
select a.id, b.drink
from r as a, drink as b
where a.r=b.r
