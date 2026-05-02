/*
 * Problem: 2993. Friday Purchases I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/friday-purchases-i/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
select WEEK(purchase_date)-43 as week_of_month, purchase_date, SUM(amount_spend) as total_amount
from Purchases
where DATE_FORMAT( purchase_date,'%Y%m')='202311' and DAYOFWEEK(purchase_date)=6
group by purchase_date
order by week_of_month
