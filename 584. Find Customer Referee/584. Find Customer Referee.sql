/*
 * Problem: 584. Find Customer Referee
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-customer-referee/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select name
from Customer
where referee_id !=2 or referee_id is null
