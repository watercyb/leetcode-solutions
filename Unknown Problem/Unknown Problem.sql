/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-books-with-no-available-copies/
 * Language: mysql
 * Date: 2026-05-08
 */

# Write your MySQL query statement below
with t as (
    select a.*, COUNT(b.record_id) as current_borrowers
    from library_books as a
    join (select * from borrowing_records where return_date is null) as b
    on a.book_id=b.book_id
    group by book_id
    having a.total_copies=current_borrowers
)
select book_id, title, author, genre, publication_year, current_borrowers
from t
order by current_borrowers desc, title
