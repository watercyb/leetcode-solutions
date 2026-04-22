/*
 * Problem: 1988. Find Cutoff Score for Each School
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-cutoff-score-for-each-school/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
select a.school_id, IFNULL(MIN(b.score),-1) as score
from Schools as a
left join Exam as b
on a.capacity>=student_count
group by school_id
