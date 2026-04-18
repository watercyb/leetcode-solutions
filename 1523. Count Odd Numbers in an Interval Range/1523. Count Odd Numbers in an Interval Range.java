/*
 * Problem: 1523. Count Odd Numbers in an Interval Range
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 1 || high % 2 == 1)
            return (high - low) / 2 + 1;
        return (high - low) / 2;
    }
}
