/*
 * Problem: 3358. Books with NULL Ratings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/books-with-null-ratings/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-03
 */

# Write your MySQL query statement below
select  book_id, title, author, published_year
from books
where rating is null
order by book_id
