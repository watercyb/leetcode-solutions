/*
 * Problem: 596. Classes With at Least 5 Students
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/classes-with-at-least-5-students/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select class
from Courses
group by class
having COUNT(student)>=5
