/*
 * Problem: 2504. Concatenate the Name and the Profession
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/concatenate-the-name-and-the-profession/
 * Language: mysql
 * Date: 2026-04-28
 */

# Write your MySQL query statement below
select person_id, CONCAT(name,'(',LEFT(profession,1),')') as name
from Person
order by person_id desc
