/*
 * Problem: 2991. Top Three Wineries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/top-three-wineries/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
with sm as (
    select country, winery, SUM(points) as points
    from Wineries
    group by country, winery
),
rnk as (
    select country, winery, points, RANK() over (partition by country order by points desc, winery) as r
    from sm
),
cmb as (
    select country, CONCAT(winery,' (',points,')' ) as top_winery, LEAD(CONCAT(winery,' (',points,')'),1,'No second winery') over (partition by country order by r) as second_winery, LEAD(CONCAT(winery,' (',points,')'),2,'No third winery') over (partition by country order by r) as third_winery, r
    from rnk
)
select country, top_winery, second_winery, third_winery
from cmb
where r=1
