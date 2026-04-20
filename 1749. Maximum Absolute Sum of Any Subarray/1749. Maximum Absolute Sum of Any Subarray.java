/*
 * Problem: 1749. Maximum Absolute Sum of Any Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sumP = 0;
        int sumN = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            sumP += nums[i];
            sumN += nums[i];
            if (sumP < 0) {
                sumP = 0;
            } else if (sumP > max) {
                max = sumP;
            }
            if (sumN > 0) {
                sumN = 0;
            } else if (sumN < min) {
                min = sumN;
            }
        }
        return Math.max(max, -min);
    }
}
