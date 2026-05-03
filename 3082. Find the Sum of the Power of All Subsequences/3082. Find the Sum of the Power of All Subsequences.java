/*
 * Problem: 3082. Find the Sum of the Power of All Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-sum-of-the-power-of-all-subsequences/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int sumOfPower(int[] nums, int k) {
        int mod = 1_000_000_007;
        long[] DP = new long[k + 1];
        DP[0] = 1;
        for (int num : nums) {
            for (int i = k - num; i >= 0; i--) {
                DP[i + num] = (DP[i + num] * 2 + DP[i]) % mod;
            }
            for (int i = Math.min(num - 1, k); i >= 0; i--) {
                DP[i] = DP[i] * 2 % mod;
            }
        }
        return (int) DP[k];
    }
}
