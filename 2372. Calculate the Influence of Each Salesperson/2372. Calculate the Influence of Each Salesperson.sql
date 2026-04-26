/*
 * Problem: 2372. Calculate the Influence of Each Salesperson
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/calculate-the-influence-of-each-salesperson/
 * Language: mysql
 * Date: 2026-04-26
 */

# Write your MySQL query statement below
with sc as (
    select a.*, b.customer_id
    from Salesperson as a
    left join Customer as b
    on a.salesperson_id=b.salesperson_id
)
select a.salesperson_id, a.name, IFNULL(SUM(b.price),0) as total
from sc as a
left join Sales as b
on a.customer_id=b.customer_id
group by salesperson_id
