/*
 * Problem: 1440. Evaluate Boolean Expression
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/evaluate-boolean-expression/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select a.*, (case when operator='>' and b.value>c.value then 'true'
when operator='<' and b.value<c.value then 'true'
when operator='=' and b.value=c.value then 'true'
else 'false' end) as value
from Expressions as a
left join Variables as b
on a.left_operand=b.name
left join Variables as c
on a.right_operand=c.name
