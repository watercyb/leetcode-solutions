/*
 * Problem: 196. Delete Duplicate Emails
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/delete-duplicate-emails/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
delete
from Person
where id not in (select id from (select MIN(id) as id from Person group by email) as a)
