/*
 * Problem: 3051. Find Candidates for Data Scientist Position
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-candidates-for-data-scientist-position/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with sm as (select candidate_id, SUM(case when skill='Python' or skill='Tableau' or skill='PostgreSQL' then 1 else 0 end) as sm
from Candidates
group by candidate_id)
select candidate_id
from sm
where sm=3
order by candidate_id
