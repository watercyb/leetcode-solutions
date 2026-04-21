/*
 * Problem: 1811. Find Interview Candidates
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-interview-candidates/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
with a as (select contest_id, gold_medal as id
from Contests
union all
select contest_id, silver_medal
from Contests
union all
select contest_id, bronze_medal
from Contests),
b as (select distinct a.id
from a as a, a as b, a as c
where a.contest_id+1=b.contest_id and b.contest_id+1=c.contest_id and a.id=b.id and b.id=c.id)
select name, mail
from Users
where user_id in (select id from b)
union
select name, mail
from Users
where (select COUNT(*) from Contests where gold_medal=Users.user_id group by gold_medal)>=3
