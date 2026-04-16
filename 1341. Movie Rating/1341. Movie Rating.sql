/*
 * Problem: 1341. Movie Rating
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/movie-rating/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
(select b.name as results
from MovieRating as a, Users as b
where a.user_id=b.user_id
group by a.user_id
order by COUNT(*) desc, b.name
limit 1)
union all
(select b.title as results
from MovieRating as a, Movies as b
where DATE_FORMAT(a.created_at,'%Y_%m')='2020_02' and a.movie_id=b.movie_id
group by a.movie_id
order by AVG(a.rating) desc, b.title
limit 1)
