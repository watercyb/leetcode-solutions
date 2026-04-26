/*
 * Problem: 2308. Arrange Table by Gender
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/arrange-table-by-gender/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
select user_id, gender
from Genders
order by ROW_NUMBER() over (partition by gender order by user_id), LENGTH(gender) desc
