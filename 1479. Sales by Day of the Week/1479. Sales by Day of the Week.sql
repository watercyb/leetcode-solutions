/*
 * Problem: 1479. Sales by Day of the Week
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sales-by-day-of-the-week/
 * Language: mysql
 * Date: 2026-04-17
 */

# Write your MySQL query statement below
select item_category as CATEGORY, SUM(case when w=0 then quantity else 0 end) as MONDAY,
SUM(case when w=1 then quantity else 0 end) as TUESDAY, SUM(case when w=2 then quantity else 0 end) as WEDNESDAY,
SUM(case when w=3 then quantity else 0 end) as THURSDAY, SUM(case when w=4 then quantity else 0 end) as FRIDAY,
SUM(case when w=5 then quantity else 0 end) as SATURDAY, SUM(case when w=6 then quantity else 0 end) as SUNDAY
from
(select WEEKDAY(b.order_date) as w, b.quantity, a.item_category
from Items as a
left join Orders as b
on a.item_id=b.item_id) as a
group by item_category
order by item_category
