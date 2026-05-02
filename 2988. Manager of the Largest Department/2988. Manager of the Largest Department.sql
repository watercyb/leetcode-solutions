/*
 * Problem: 2988. Manager of the Largest Department
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/manager-of-the-largest-department/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with r as (select dep_id, rank() over (order by COUNT(*) desc) as rnk
from Employees
group by dep_id)
select (select emp_name from Employees where dep_id=r.dep_id and position='Manager') as manager_name, dep_id
from r
where rnk=1
order by dep_id
