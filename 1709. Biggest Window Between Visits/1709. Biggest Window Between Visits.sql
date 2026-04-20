/*
 * Problem: 1709. Biggest Window Between Visits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/biggest-window-between-visits/
 * Language: mysql
 * Date: 2026-04-20
 */

# Write your MySQL query statement below
select user_id, MAX(diff) as biggest_window
from
(select user_id, DATEDIFF(IFNULL(lead(visit_date) over (partition by user_id order by visit_date),'2021-01-01'),visit_date) as diff
from UserVisits) as a
group by user_id
order by user_id
