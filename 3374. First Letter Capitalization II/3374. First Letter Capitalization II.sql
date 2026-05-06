/*
 * Problem: 3374. First Letter Capitalization II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/first-letter-capitalization-ii/
 * Language: mysql
 * Date: 2026-05-06
 */

# Write your MySQL query statement below
with recursive cte as (
    select *, REGEXP_SUBSTR(content_text, '[^- ]+[- ]?', 1, 1) as word, 2 as n
    from user_content
    union all
    select content_id, content_text, REGEXP_SUBSTR(content_text, '[^- ]+[- ]?', 1, n) as word, n+1
    from cte
    where REGEXP_SUBSTR(content_text, '[^- ]+[- ]?', 1, n) is not null
),
cpt as (
    select content_id, content_text, CONCAT(UCASE(LEFT(word, 1)), LCASE(SUBSTRING(word, 2))) as word, n
    from cte
)
select content_id, content_text as original_text, GROUP_CONCAT(word order by n separator '') as converted_text
from cpt
group by content_id
