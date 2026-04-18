/*
 * Problem: 1571. Warehouse Manager
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/warehouse-manager/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
with v as (select product_id, Width*Length*Height as volume
from Products)
select a.name as warehouse_name, SUM(b.volume*a.units) as volume
from Warehouse as a, v as b
where a.product_id=b.product_id
group by warehouse_name
