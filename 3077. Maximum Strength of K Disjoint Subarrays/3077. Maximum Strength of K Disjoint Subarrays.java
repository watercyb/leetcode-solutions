/*
 * Problem: 3077. Maximum Strength of K Disjoint Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-strength-of-k-disjoint-subarrays/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long maximumStrength(int[] nums, int k) {
        long[] DP = new long[k + 1];
        long[] DP1 = new long[k + 1];
        Arrays.fill(DP, Long.MIN_VALUE / 2);
        Arrays.fill(DP1, Long.MIN_VALUE / 2);
        DP[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int lim = Math.min(i, k - 1);
            long sign = 1 - lim % 2 * 2;
            for (int j = lim; j >= 0; j--) {
                DP1[j] = Math.max(DP1[j], DP[j]) + sign * nums[i] * (k - j);
                DP[j + 1] = Math.max(DP[j + 1], DP1[j]);
                sign=-sign;
            }
        }
        return DP[k];
    }
}
