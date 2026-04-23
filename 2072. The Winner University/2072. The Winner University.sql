/*
 * Problem: 2072. The Winner University
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-winner-university/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
select (case when (select COUNT(student_id) from NewYork where score>=90)>(select COUNT(student_id) from California where score>=90) then 'New York University' when (select COUNT(student_id) from NewYork where score>=90)<(select COUNT(student_id) from California where score>=90) then 'California University' else 'No Winner' end) as winner
