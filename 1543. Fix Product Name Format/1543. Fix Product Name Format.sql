/*
 * Problem: 1543. Fix Product Name Format
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fix-product-name-format/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select trim(lower(product_name)) as product_name,date_format(sale_date, "%Y-%m") as sale_date, count(sale_id) as total
from Sales
group by date_format(sale_date, "%Y-%m"),trim(lower(product_name))
order by trim(lower(product_name)),date_format(sale_date, "%Y-%m")
