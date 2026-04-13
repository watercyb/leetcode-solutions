/*
 * Problem: 3580. Find Consistently Improving Employees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-consistently-improving-employees/?envType=problem-list-v2&envId=ne414q67
 * Language: mysql
 * Date: 2026-04-13
 */

# Write your MySQL query statement below
with rnk as (
    select employee_id, rating, ROW_NUMBER() over (partition by employee_id order by review_date desc) as rnk
    from performance_reviews
),
grp as (
    select employee_id, rating, LAG(rating) over (partition by employee_id order by rnk) as prv, LEAD(rating) over (partition by employee_id order by rnk) as next, rnk
    from rnk
),
imp as (
    select employee_id, prv-next as improvement_score
    from grp
    where rnk=2 and rating<prv and next<rating
)
select a.employee_id, b.name, a.improvement_score
from imp as a, employees as b
where a.employee_id=b.employee_id
order by improvement_score desc, name
