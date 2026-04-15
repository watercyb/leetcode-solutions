/*
 * Problem: 1294. Weather Type in Each Country
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/weather-type-in-each-country/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
select a.country_name, (case when AVG(weather_state)<=15 then "Cold" when AVG(weather_state)>=25 then 'Hot' else 'Warm' end) as weather_type
from Countries as a, Weather as b
where a.country_id=b.country_id and b.day>='2019-11-01' and b.day<'2019-12-01'
group by a.country_name
