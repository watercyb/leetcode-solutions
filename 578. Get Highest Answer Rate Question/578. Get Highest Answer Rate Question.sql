/*
 * Problem: 578. Get Highest Answer Rate Question
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/get-highest-answer-rate-question/
 * Language: mysql
 * Date: 2026-04-04
 */

# Write your MySQL query statement below
select question_id as survey_log
from SurveyLog
group by question_id
order by SUM(case when action='answer' then 1 else 0 end)/SUM(case when action='show' then 1 else 0 end) desc, question_id
limit 1
