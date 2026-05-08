/*
 * Problem: 3521. Find Product Recommendation Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-product-recommendation-pairs/
 * Language: mysql
 * Date: 2026-05-08
 */

# Write your MySQL query statement below
with cmb as (
    select a.user_id, a.product_id, b.category
    from ProductPurchases as a, ProductInfo as b
    where a.product_id=b.product_id
)
select a.product_id as product1_id, b.product_id as product2_id, a.category as product1_category, b.category as product2_category, COUNT(*) as customer_count
from cmb as a, cmb as b
where a.user_id=b.user_id and a.product_id<b.product_id
group by a.product_id, b.product_id
having customer_count>=3
order by customer_count desc, product1_id, product2_id
