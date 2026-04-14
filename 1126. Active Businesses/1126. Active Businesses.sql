/*
 * Problem: 1126. Active Businesses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/active-businesses/
 * Language: mysql
 * Date: 2026-04-14
 */

# Write your MySQL query statement below
select business_id
from
(select business_id, AVG(occurrences) over (partition by business_id, event_type) as a,
AVG(occurrences) over (partition by event_type) as b
from Events
group by business_id, event_type) as a
where a>b
group by business_id
having COUNT(*)>1
