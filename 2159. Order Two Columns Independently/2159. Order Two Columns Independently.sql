/*
 * Problem: 2159. Order Two Columns Independently
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/order-two-columns-independently/
 * Language: mysql
 * Date: 2026-04-24
 */

# Write your MySQL query statement below
with col1 as (select first_col, ROW_NUMBER() over (order by first_col) as r
from Data),
col2 as (select second_col, ROW_NUMBER() over (order by second_col desc) as r
from Data)
select a.first_col, b.second_col
from col1 as a, col2 as b
where a.r=b.r
