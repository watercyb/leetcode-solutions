/*
 * Problem: 674. Longest Continuous Increasing Subsequence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int prv = Integer.MIN_VALUE;
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num > prv) {
                count++;
            } else {
                res = Math.max(count, res);
                count = 1;
            }
            prv = num;
        }
        return Math.max(count, res);
    }
}
