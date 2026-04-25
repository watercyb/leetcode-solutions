/*
 * Problem: 2230. The Users That Are Eligible for Discount
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-users-that-are-eligible-for-discount/
 * Language: mysql
 * Date: 2026-04-25
 */

CREATE PROCEDURE getUserIDs(startDate DATE, endDate DATE, minAmount INT)
BEGIN
	# Write your MySQL query statement below.
	select distinct user_id
    from Purchases
    where time_stamp>=startDate and time_stamp<=endDate and amount>=minAmount
    order by user_id;
END
