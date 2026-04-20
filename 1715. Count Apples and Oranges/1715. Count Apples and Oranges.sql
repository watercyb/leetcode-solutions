/*
 * Problem: 1715. Count Apples and Oranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-apples-and-oranges/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select SUM(a.apple_count + IFNULL(b.apple_count,0)) as apple_count, SUM(a.orange_count + IFNULL(b.orange_count,0)) as orange_count
from Boxes as a
left join Chests as b
on a.chest_id=b.chest_id
