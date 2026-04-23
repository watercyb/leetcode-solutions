/*
 * Problem: 2051. The Category of Each Member in the Store
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-category-of-each-member-in-the-store/
 * Language: mysql
 * Date: 2026-04-23
 */

# Write your MySQL query statement below
with r as (select a.member_id, a.name, SUM((case when b.visit_id in (select visit_id from Purchases) then 1 else 0 end))/COUNT(b.visit_id) as r
from Members as a
left join Visits as b
on a.member_id=b.member_id
group by a.member_id)
select member_id, name, (case when r>=0.8 then 'Diamond' when r>=0.5 then 'Gold' when r>=0.5 then 'Gold'  when r>=0 then 'Silver' else 'Bronze' end) as category
from r
