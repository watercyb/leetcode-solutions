/*
 * Problem: 1767. Find the Subtasks That Did Not Execute
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-subtasks-that-did-not-execute/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
with recursive a as (
select task_id, subtasks_count
from Tasks
union all
select task_id, subtasks_count-1 as subtasks_count
from a
where subtasks_count>1)
select task_id, subtasks_count as subtask_id
from a
where (task_id, subtasks_count) not in (select * from Executed)
