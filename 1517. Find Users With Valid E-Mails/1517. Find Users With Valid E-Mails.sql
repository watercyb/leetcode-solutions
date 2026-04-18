/*
 * Problem: 1517. Find Users With Valid E-Mails
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-users-with-valid-e-mails/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select *
from Users
where mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*\\@leetcode\\.com$'
