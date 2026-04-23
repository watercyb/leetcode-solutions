/*
 * Problem: 2041. Accepted Candidates From the Interviews
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/accepted-candidates-from-the-interviews/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
select a.candidate_id
from Candidates as a, Rounds as b
where a.years_of_exp>=2 and a.interview_id=b.interview_id
group by a.candidate_id
having sum(b.score)>15
