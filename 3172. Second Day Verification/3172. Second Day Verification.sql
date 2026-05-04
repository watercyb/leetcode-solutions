/*
 * Problem: 3172. Second Day Verification
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/second-day-verification/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
select distinct a.user_id
from emails as a, texts as b
where a.email_id=b.email_id and b.signup_action='Verified' and DATEDIFF(DATE_FORMAT(b.action_date,'%y-%m-%d'),DATE_FORMAT(a.signup_date,'%y-%m-%d'))=1
order by user_id
