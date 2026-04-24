/*
 * Problem: 2199. Finding the Topic of Each Post
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/finding-the-topic-of-each-post/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
select a.post_id, IFNULL(GROUP_CONCAT(distinct b.topic_id order by b.topic_id SEPARATOR ','),'Ambiguous!') as topic
from Posts as a
left join (select * from Keywords) as b
on CONCAT('% ', a.content, ' %') LIKE CONCAT('% ', b.word, ' %')
group by a.post_id
