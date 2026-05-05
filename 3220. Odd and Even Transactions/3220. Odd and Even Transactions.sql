/*
 * Problem: 3220. Odd and Even Transactions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/odd-and-even-transactions/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
select transaction_date, SUM(case when amount%2=1 then amount else 0 end) as odd_sum,  SUM(case when amount%2=0 then amount else 0 end) as even_sum
from transactions
group by transaction_date
order by transaction_date
