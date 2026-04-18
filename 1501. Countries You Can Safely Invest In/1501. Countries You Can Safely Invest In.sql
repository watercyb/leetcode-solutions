/*
 * Problem: 1501. Countries You Can Safely Invest In
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/countries-you-can-safely-invest-in/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select name as country
from Country
where country_code in
(select SUBSTRING(a.phone_number,1,3) as country_code
from Person as a, Calls as b
where a.id=b.caller_id or a.id=b.callee_id
group by country_code
having AVG(b.duration) > (select AVG(duration) from Calls))
