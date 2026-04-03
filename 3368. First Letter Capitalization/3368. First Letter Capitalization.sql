/*
 * Problem: 3368. First Letter Capitalization
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/first-letter-capitalization/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-03
 */

# Write your MySQL query statement below
with tab as (
    select *, CONCAT(LOWER(content_text), UPPER(content_text)) s_l_u, CONCAT('(?<=[[:space:]]|^)[a-z](?=.{', (CHAR_LENGTH(content_text) - 1), '}([A-Z]))') reg_exp, CHAR_LENGTH(content_text) len
    from user_content
)
select content_id, content_text as original_text, SUBSTR(REGEXP_REPLACE(s_l_u, reg_exp, '$1'), 1, len) as converted_text
from tab
