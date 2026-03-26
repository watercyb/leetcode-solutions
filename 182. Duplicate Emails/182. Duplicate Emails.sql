/*
 * Problem: 182. Duplicate Emails
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/duplicate-emails/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
select Email
from Person
group by email
having COUNT(email)>1
