/*
 * Problem: 3050. Pizza Toppings Cost Analysis
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pizza-toppings-cost-analysis/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
select CONCAT(a.topping_name,',',b.topping_name,',',c.topping_name) as pizza, a.cost+b.cost+c.cost as total_cost
from Toppings as a, Toppings as b, Toppings as c
where a.topping_name<b.topping_name and b.topping_name<c.topping_name
order by total_cost desc, pizza
