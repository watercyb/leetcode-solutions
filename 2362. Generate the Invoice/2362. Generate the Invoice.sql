/*
 * Problem: 2362. Generate the Invoice
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/generate-the-invoice/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with s as (
    select a.invoice_id, a.product_id, SUM(a.quantity) as quantity, SUM(b.price*a.quantity) as price
    from Purchases as a, Products as b
    where a.product_id=b.product_id
    group by a.invoice_id, a.product_id
),
s1 as (
    select invoice_id, SUM(price) price
    from s
    group by invoice_id
),
r as (
    select invoice_id, RANK() over (order by price desc, invoice_id) as r
    from s1
)
select product_id, quantity, price
from s
where (invoice_id, 1) in (select * from r)
