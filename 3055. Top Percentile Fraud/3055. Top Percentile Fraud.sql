/*
 * Problem: 3055. Top Percentile Fraud
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/top-percentile-fraud/
 * Language: mysql
 * Date: 2026-05-03
 */

# Write your MySQL query statement below
with r as (select *, RANK() over (partition by state order by fraud_score desc) as r
from Fraud),
total as (select state, COUNT(*) as total
from Fraud
group by state)
select a.policy_id, a.state, a.fraud_score
from r as a, total as b
where a.state=b.state and (a.r-1)/b.total<=0.05
order by state, fraud_score desc, policy_id
