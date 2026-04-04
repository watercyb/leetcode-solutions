/*
 * Problem: 571. Find Median Given Frequency of Numbers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-median-given-frequency-of-numbers/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select ROUND(AVG(num),1) as median
from (select *, SUM(frequency) over (order by num) as r1,
SUM(frequency) over (order by num desc) as r2,
SUM(frequency) over () as total
from Numbers) as a
where r1>=total/2 and r2>=total/2
