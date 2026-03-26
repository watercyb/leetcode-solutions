/*
 * Problem: 175. Combine Two Tables
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/combine-two-tables/
 * Language: mysql
 * Date: 2026-03-26
 */

# Write your MySQL query statement below
SELECT Person.firstName, Person.lastName, Address.city, Address.state
FROM Person
LEFT JOIN Address
ON Person.personId=Address.personId;
