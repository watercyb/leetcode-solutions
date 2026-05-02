/*
 * Problem: 2978. Symmetric Coordinates
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/symmetric-coordinates/
 * Language: mysql
 * Date: 2026-05-02
 */

# Write your MySQL query statement below
select distinct X, Y
from Coordinates
where X<Y and (X,Y) in (select Y, X from Coordinates)
union all
select X, Y
from (
    select X, Y, COUNT(*) as sm
    from Coordinates
    where X=Y
    group by X, Y
) as a
where sm>1
order by X, Y
