/*
 * Problem: 1098. Unpopular Books
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unpopular-books/
 * Language: mysql
 * Date: 2026-04-12
 */

# Write your MySQL query statement below
with a as (select book_id
from Books
where available_from+interval 30 day>='2019-06-23'),
b as (select book_id, SUM(case when dispatch_date+interval 365 day>='2019-06-23' then quantity else 0 end) as count
from Orders
group by book_id
having count>=10)
select book_id, name
from Books
where book_id not in (select book_id from a) and book_id not in (select book_id from b)
