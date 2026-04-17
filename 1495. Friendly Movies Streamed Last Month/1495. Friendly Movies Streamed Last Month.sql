/*
 * Problem: 1495. Friendly Movies Streamed Last Month
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/friendly-movies-streamed-last-month/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select distinct a.title
from (select * from Content where Kids_content='Y' and content_type='Movies') as a,
(select * from TVProgram where DATE_FORMAT(program_date,'%Y-%m')='2020-06') as b
where a.content_id=b.content_id
