/*
 * Problem: 1527. Patients With a Condition
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/patients-with-a-condition/
 * Language: mysql
 * Date: 2026-04-18
 */

# Write your MySQL query statement below
select *
from Patients
where conditions REGEXP '\\bDIAB1' 
