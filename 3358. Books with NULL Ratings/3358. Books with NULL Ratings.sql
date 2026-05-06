/*
 * Problem: 3358. Books with NULL Ratings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/books-with-null-ratings/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
select  book_id, title, author, published_year
from books
where rating is null
order by book_id
