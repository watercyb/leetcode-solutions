/*
 * Problem: 1667. Fix Names in a Table
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fix-names-in-a-table/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select user_id, CONCAT(UPPER(MID(name,1,1)),LOWER(MID(name,2))) as name
from Users
order by user_id
