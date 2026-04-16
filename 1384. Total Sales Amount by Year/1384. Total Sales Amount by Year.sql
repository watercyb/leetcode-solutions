/*
 * Problem: 1384. Total Sales Amount by Year
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/total-sales-amount-by-year/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select *
from
(select b.product_id, a.product_name, '2018' as report_year, ((DATEDIFF(LEAST(b.period_end,'2018-12-31'),GREATEST(b.period_start, '2018-01-01')))+1)*b.average_daily_sales as total_amount
from Product as a, Sales as b
where a.product_id=b.product_id
group by b.product_id
having total_amount>0
union
select b.product_id, a.product_name, '2019' as report_year, ((DATEDIFF(LEAST(b.period_end,'2019-12-31'),GREATEST(b.period_start, '2019-01-01')))+1)*b.average_daily_sales as total_amount
from Product as a, Sales as b
where a.product_id=b.product_id
group by b.product_id
having total_amount>0
union
select b.product_id, a.product_name, '2020' as report_year, ((DATEDIFF(LEAST(b.period_end,'2020-12-31'),GREATEST(b.period_start, '2020-01-01')))+1)*b.average_daily_sales as total_amount
from Product as a, Sales as b
where a.product_id=b.product_id
group by b.product_id
having total_amount>0) as a
order by product_id, report_year
