/*
 * Problem: 2529. Maximum Count of Positive Integer and Negative Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int maximumCount(int[] nums) {
        int p = 0;
        int n = 0;
        for (int num : nums) {
            if (num > 0) {
                p++;
            } else if (num < 0) {
                n++;
            }
        }
        return Math.max(p, n);
    }
}
