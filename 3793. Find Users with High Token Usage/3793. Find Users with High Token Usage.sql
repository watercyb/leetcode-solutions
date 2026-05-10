/*
 * Problem: 3793. Find Users with High Token Usage
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-users-with-high-token-usage/
 * Language: mysql
 * Date: 2026-05-10
 */

# Write your MySQL query statement below
select user_id, COUNT(prompt) as prompt_count, ROUND(AVG(tokens),2) as avg_tokens
from prompts
group by user_id
having prompt_count>=3 and COUNT(distinct tokens)!=1
order by avg_tokens desc, user_id
