/*
 * Problem: 3554. Find Category Recommendation Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-category-recommendation-pairs/
 * Language: mysql
 * Date: 2026-05-08
 */

# Write your MySQL query statement below
with cmb as (
    select distinct a.user_id, b.category
    from ProductPurchases as a, ProductInfo as b
    where a.product_id=b.product_id
)
select a.category as category1, b.category as category2, COUNT(*) as customer_count
from cmb as a, cmb as b
where a.user_id=b.user_id and a.category<b.category
group by a.category, b.category
having customer_count>=3
order by customer_count desc, category1, category2
