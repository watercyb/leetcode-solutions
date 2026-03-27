/*
 * Problem: 3278. Find Candidates for Data Scientist Position II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-candidates-for-data-scientist-position-ii/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-03-27
 */

# Write your MySQL query statement below
with total as (select a.project_id, b.candidate_id, case when b.proficiency>a.importance then 10 when b.proficiency<a.importance then -5 else 0 end as p
from Projects as a
left join Candidates as b
on a.skill=b.skill),
r1 as (select project_id, candidate_id, SUM(p) as s
from total as a
group by project_id, candidate_id
having COUNT(*)=(select COUNT(skill) from Projects where project_id=a.project_id)),
r2 as (select *, RANK() over (partition by project_id order by s desc, candidate_id) as r
from r1)
select project_id, candidate_id, s+100 as score
from r2
where r=1
