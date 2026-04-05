/*
 * Problem: 608. Tree Node
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/tree-node/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select id, case
    when p_id is null then 'Root' else
        case when id in (select p_id from Tree) then 'Inner' else 'Leaf' end
    end as type
from Tree
