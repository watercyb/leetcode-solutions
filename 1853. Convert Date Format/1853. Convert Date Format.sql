/*
 * Problem: 1853. Convert Date Format
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-date-format/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select DATE_FORMAT(day, '%W, %M %e, %Y') as day
from Days
