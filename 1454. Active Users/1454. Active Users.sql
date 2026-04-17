/*
 * Problem: 1454. Active Users
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/active-users/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select *
from Accounts
where id in
(select id
from 
(select id, rank() over (partition by id order by login_date) as r, login_date
from (select distinct id, login_date from Logins) as a
order by id, login_date) as a
group by id, login_date-interval r day
having COUNT(*)>=5)
order by id
