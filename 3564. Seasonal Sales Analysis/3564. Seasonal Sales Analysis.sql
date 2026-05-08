/*
 * Problem: 3564. Seasonal Sales Analysis
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/seasonal-sales-analysis/
 * Language: mysql
 * Date: 2026-05-08
 */

# Write your MySQL query statement below
with cmb as (
    select a.product_id, FLOOR(MONTH(a.sale_date)%12/3) as season, a.quantity, a.price, b.category
    from sales as a, products as b
    where a.product_id=b.product_id
),
sm as (
    select product_id, season, SUM(quantity) as total_quantity, SUM(quantity*price) as total_revenue, category
    from cmb
    group by category, season
),
rnk as (
    select *, RANK() over (partition by season order by total_quantity desc, total_revenue desc) as r
    from sm
)
select (case when season=0 then 'Winter' when season=1 then 'Spring' when season=2 then 'Summer' else 'Fall' end) as season, category, total_quantity, total_revenue
from rnk
where r=1
order by season
