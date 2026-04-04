/*
 * Problem: 585. Investments in 2016
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/investments-in-2016/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select *
from Insurance
where tiv_2015 in
(select tiv_2015
from Insurance
group by tiv_2015
having COUNT(*)>1)
and pid in
(select pid
from Insurance
group by lat, lon
having COUNT(*)=1)
