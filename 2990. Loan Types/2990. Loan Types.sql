/*
 * Problem: 2990. Loan Types
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/loan-types/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with sm as (
    select user_id, SUM(case when loan_type='Mortgage' then 1 else 0 end) as m, SUM(case when loan_type='Refinance' then 1 else 0 end) as r
    from Loans
    group by user_id
)
select user_id
from sm
where m>=1 and r>=1
order by user_id
