/*
 * Problem: 3642. Find Books with Polarized Opinions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-books-with-polarized-opinions/
 * Language: mysql
 * Date: 2026-05-09
 */

# Write your MySQL query statement below
with t as (
    select *, (case when session_rating<=2 then 1 else 0 end) as l, (case when session_rating>=4 then 1 else 0 end) as r
    from reading_sessions
),
grp as (
    select book_id, SUM(l) as l, SUM(r) as r, MAX(session_rating)-MIN(session_rating) as rating_spread, ROUND((SUM(l)+SUM(r))/COUNT(*), 2) as polarization_score
    from t
    group by book_id
    having l>0 and r>0 and COUNT(*)>=5 and polarization_score>=0.6
)
select a.*, b.rating_spread, b.polarization_score
from books as a, grp as b
where a.book_id=b.book_id
order by polarization_score desc, title desc
