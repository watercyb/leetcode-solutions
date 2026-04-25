/*
 * Problem: 2205. The Number of Users That Are Eligible for Discount
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-number-of-users-that-are-eligible-for-discount/
 * Language: mysql
 * Date: 2026-04-25
 */

CREATE FUNCTION getUserIDs(startDate DATE, endDate DATE, minAmount INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select COUNT(distinct user_id)
      from Purchases
      where time_stamp>=startDate and time_stamp<=endDate and amount>=minAmount
  );
END
