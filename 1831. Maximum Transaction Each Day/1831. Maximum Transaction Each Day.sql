/*
 * Problem: 1831. Maximum Transaction Each Day
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-transaction-each-day/
 * Language: mysql
 * Date: 2026-04-21
 */

# Write your MySQL query statement below
select transaction_id
from
(select transaction_id, RANK() over (partition by DATE_FORMAT(day,'%Y-%m-%d') order by amount desc) as r
from Transactions) as a
where r=1
order by transaction_id
