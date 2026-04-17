/*
 * Problem: 1421. NPV Queries
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/npv-queries/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select a.id, a.year, IFNULL(b.npv,0) as npv
from Queries as a
left join NPV as b
on a.id=b.id and a.year=b.year
