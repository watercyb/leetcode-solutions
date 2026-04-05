/*
 * Problem: 601. Human Traffic of Stadium
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/human-traffic-of-stadium/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
with a as (select id, rank() over (order by id) as r, visit_date, people
from Stadium
where people>=100)
select id, visit_date, people
from a
where id-r in (select id-r
from a
group by id-r
having COUNT(*)>=3)
