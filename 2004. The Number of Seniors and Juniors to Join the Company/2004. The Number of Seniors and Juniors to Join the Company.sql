/*
 * Problem: 2004. The Number of Seniors and Juniors to Join the Company
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-number-of-seniors-and-juniors-to-join-the-company/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
with r as (select *, ROW_NUMBER() over (partition by experience order by salary) as r
from Candidates
where experience='Senior'),
sum as (select *, SUM(salary) over (partition by experience order by r) as sum
from r),
r1 as (select experience, sum, r, ROW_NUMBER() over (partition by experience order by sum desc) as r1
from sum
where sum<=70000
limit 1),
r2 as (select *, ROW_NUMBER() over (partition by experience order by salary) as r
from Candidates
where experience='Junior'),
sum1 as (select *, SUM(salary) over (partition by experience order by r) as sum
from r2),
r3 as (select experience, r, ROW_NUMBER() over (partition by experience order by sum desc) as r1
from sum1
where sum<=70000-IFNULL((select sum from r1),0)
limit 1),
total as (select experience, r as accepted_candidates
from r1
union all
select experience, r as accepted_candidates
from r3
union all
select 'Senior' as experience, 0 as accepted_candidates
union all
select 'Junior' as experience, 0 as accepted_candidates)
select experience, MAX(accepted_candidates) as accepted_candidates
from total
group by experience
