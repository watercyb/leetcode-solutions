/*
 * Problem: 618. Students Report By Geography
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/students-report-by-geography/
 * Language: mysql
 * Date: 2026-04-05
 */

# Write your MySQL query statement below
with r as (select case when continent='America' then name end as America,
case when continent='Asia' then name end as Asia,
case when continent='Europe' then name end as Europe,
ROW_NUMBER() over (partition by continent order by name) as r
from Student)
select MIN(America) as America, MIN(Asia) as Asia, MIN(Europe) as Europe
from r
group by r
