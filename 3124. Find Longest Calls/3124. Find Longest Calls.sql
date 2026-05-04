/*
 * Problem: 3124. Find Longest Calls
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-longest-calls/
 * Language: mysql
 * Date: 2026-05-04
 */

# Write your MySQL query statement below
with r as (
    select a.first_name, b.type, b.duration as t, ROW_NUMBER() over (partition by b.type order by b.duration desc) as r
    from Contacts as a, Calls as b
    where a.id=b.contact_id
)
select first_name, type, CONCAT(RIGHT(CONCAT('00', FLOOR(t / 3600)),2),':',RIGHT(CONCAT('00', FLOOR(t / 60 % 60)),2),':',RIGHT(CONCAT('00', FLOOR(t % 60)),2)) as duration_formatted
from r
where r<=3
order by type desc, duration_formatted desc, first_name desc
