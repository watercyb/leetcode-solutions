/*
 * Problem: 2480. Form a Chemical Bond
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/form-a-chemical-bond/
 * Language: mysql
 * Date: 2026-04-27
 */

# Write your MySQL query statement below
select a.symbol as metal, b.symbol as nonmetal
from (select symbol from Elements where type='Metal') as a, (select symbol from Elements where type='Nonmetal') as b
where a.symbol!=b.symbol
