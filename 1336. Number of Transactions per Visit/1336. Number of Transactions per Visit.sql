/*
 * Problem: 1336. Number of Transactions per Visit
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-transactions-per-visit/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
with a as (select count transactions_count, COUNT(*) as visits_count
from
(select user_id, transaction_date, COUNT(*) as count
from Transactions
group by user_id, transaction_date) as a
group by count
union
select 0 as transactions_count, COUNT(*) as visits_count
from
(select user_id, visit_date
from Visits
where (user_id, visit_date) not in (select user_id, transaction_date from Transactions)) as a),
b as (select r as r
from
(select ROW_NUMBER() over (order by user_id) as r
from Transactions) as b
where r<=(select MAX(transactions_count) from a)
union
select 0 as r)
select b.r as transactions_count, IFNULL(a.visits_count,0) as visits_count
from b
left join a
on b.r=a.transactions_count
order by transactions_count
