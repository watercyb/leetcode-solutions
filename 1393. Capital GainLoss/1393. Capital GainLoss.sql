/*
 * Problem: 1393. Capital Gain/Loss
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/capital-gainloss/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
select stock_name, SUM(case when operation='Buy' then -price else price end) as capital_gain_loss
from Stocks
group by stock_name
