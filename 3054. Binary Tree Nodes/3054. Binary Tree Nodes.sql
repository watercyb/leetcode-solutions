/*
 * Problem: 3054. Binary Tree Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-tree-nodes/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
select N, case when P is null then 'Root' when N in (select P from Tree) then 'Inner' else 'Leaf' end as Type
from Tree
order by N
