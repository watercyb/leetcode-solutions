/*
 * Problem: 2356. Number of Unique Subjects Taught by Each Teacher
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
select teacher_id, COUNT(distinct subject_id) as cnt
from Teacher
group by teacher_id
