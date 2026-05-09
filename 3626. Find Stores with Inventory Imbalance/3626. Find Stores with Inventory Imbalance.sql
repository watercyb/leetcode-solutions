/*
 * Problem: 3626. Find Stores with Inventory Imbalance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-stores-with-inventory-imbalance/
 * Language: mysql
 * Date: 2026-05-09
 */

# Write your MySQL query statement below
with valid as (
    select store_id
    from inventory
    group by store_id
    having COUNT(product_name)>=3
),
rnk as (
    select *, rank() over (partition by store_id order by price desc) as r1, rank() over (partition by store_id order by price) as r2
    from inventory
    where store_id in (select store_id from valid)
),
mx as (
    select store_id, product_name, quantity
    from rnk
    where r1=1
),
mi as (
    select store_id, product_name, quantity
    from rnk
    where r2=1
),
mrg as (
    select a.store_id, a.product_name as most_exp_product, b.product_name as cheapest_product, ROUND(b.quantity/a.quantity,2) as imbalance_ratio
    from mx as a, mi as b
    where a.store_id=b.store_id
    having imbalance_ratio>1
)
select b.*, a.most_exp_product, a.cheapest_product, a.imbalance_ratio
from mrg as a, stores as b
where a.store_id=b.store_id
order by imbalance_ratio desc, store_name
