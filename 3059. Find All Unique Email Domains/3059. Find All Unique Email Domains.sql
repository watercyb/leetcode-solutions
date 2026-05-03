/*
 * Problem: 3059. Find All Unique Email Domains
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-all-unique-email-domains/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
select SUBSTRING_INDEX(email, '@', -1) as email_domain, COUNT(*) as 'count'
from Emails
where RIGHT(email, 3)='com'
group by email_domain
order by email_domain
