/*
 * Problem: 1205. Monthly Transactions II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/monthly-transactions-ii/
 * Language: mysql
 * Date: 2026-04-15
 */

# Write your MySQL query statement below
with l as (select DATE_FORMAT(trans_date,'%Y-%m') as month, country,
COUNT(*) approved_count,
SUM(amount) as approved_amount
from Transactions
where state='approved'
group by DATE_FORMAT(trans_date,'%Y-%m'), country),
r as (select DATE_FORMAT(a.trans_date,'%Y-%m') as month, b.country, COUNT(b.amount) as chargeback_count, SUM(b.amount) as chargeback_amount
from Chargebacks as a, Transactions as b
where a.trans_id=b.id
group by month, country)
select a.*, IFNULL(b.chargeback_count,0) as chargeback_count, IFNULL(b.chargeback_amount,0) as chargeback_amount
from l as a
left join r as b
on a.month=b.month and a.country=b.country
union all
select DATE_FORMAT(a.trans_date,'%Y-%m') as month, b.country, 0 as approved_count, 0 as approved_amount,
COUNT(b.amount) as chargeback_count, SUM(b.amount) as chargeback_amount
from Chargebacks as a, Transactions as b
where a.trans_id=b.id and (DATE_FORMAT(a.trans_date,'%Y-%m'), b.country) not in (select distinct DATE_FORMAT(trans_date,'%Y-%m'), country from Transactions where state='approved')
group by month, country
