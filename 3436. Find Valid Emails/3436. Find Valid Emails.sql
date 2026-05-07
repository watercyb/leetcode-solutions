/*
 * Problem: 3436. Find Valid Emails
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-valid-emails/
 * Language: mysql
 * Date: 2026-05-07
 */

# Write your MySQL query statement below
select *
from Users
where email REGEXP '^[a-zA-Z0-9_]+@[a-zA-Z]+\.com$'
