/*
 * Problem: 1322. Ads Performance
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/ads-performance/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select ad_id, IFNULL(ROUND(SUM(action='Clicked') /(SUM(action='Clicked')+SUM( action='Viewed'))*100,2),0) as ctr
from Ads
group by ad_id
order by ctr desc, ad_id
