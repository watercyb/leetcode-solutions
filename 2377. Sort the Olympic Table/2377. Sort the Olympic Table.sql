/*
 * Problem: 2377. Sort the Olympic Table
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-the-olympic-table/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
select *
from Olympic
order by gold_medals desc, silver_medals desc, bronze_medals desc, country
