/*
 * Problem: 1693. Daily Leads and Partners
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/daily-leads-and-partners/
 * Language: mysql
 * Date: 2026-04-19
 */

# Write your MySQL query statement below
select date_id, make_name, COUNT(distinct lead_id) as unique_leads, COUNT(distinct partner_id) as unique_partners
from DailySales
group by date_id, make_name
