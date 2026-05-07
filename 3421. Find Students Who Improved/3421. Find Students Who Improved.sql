/*
 * Problem: 3421. Find Students Who Improved
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-students-who-improved/
 * Language: mysql
 * Date: 2026-05-07
 */

# Write your MySQL query statement below
with prvNext as (
    select student_id, subject, score, LAG(score) over (partition by student_id, subject order by exam_date) as prv, LEAD(score) over (partition by student_id, subject order by exam_date) as next
    from Scores
)
select a.student_id, a.subject, a.score as first_score, b.score as latest_score
from (
    select student_id, subject, score
    from prvNext
    where prv is null
) as a,
(
    select student_id, subject, score
    from prvNext
    where next is null
) as b
where a.student_id=b.student_id and a.subject=b.subject and b.score-a.score>0
order by student_id, subject
