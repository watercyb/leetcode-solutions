/*
 * Problem: 1581. Customer Who Visited but Did Not Make Any Transactions
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select customer_id, COUNT(*) as count_no_trans
from Visits
where visit_id not in (select visit_id from Transactions)
group by customer_id
