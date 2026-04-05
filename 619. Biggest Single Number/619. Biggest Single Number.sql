/*
 * Problem: 619. Biggest Single Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/biggest-single-number/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
select MAX(num) as num
from
(select num
from MyNumbers
group by num
having COUNT(num)=1) as a
