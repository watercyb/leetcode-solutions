/*
 * Problem: 2738. Count Occurrences in Text
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-occurrences-in-text/
 * Language: mysql
 * Date: 2026-04-30
 */

# Write your MySQL query statement below
select 'bull' as word, COUNT(*) as count
from Files
where content like '% bull %'
union all
select 'bear' as word, COUNT(*)
from Files
where content like '% bear %'
