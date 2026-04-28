/*
 * Problem: 2518. Number of Great Partitions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-great-partitions/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int countPartitions(int[] nums, int k) {
        int mod = 1_000_000_007;
        long[] DP = new long[k];
        DP[0] = 1;
        long res = 1;
        long sum = 0;
        for (int num : nums) {
            for (int i = k - num - 1; i >= 0; i--) {
                DP[i + num] = (DP[i + num] + DP[i]) % mod;
            }
            res = res * 2 % mod;
            sum += num;
        }
        if (sum < 2 * k)
            return 0;
        for (int i = 0; i < k; i++) {
            res = (res - DP[i] * 2) % mod;
        }
        return (int) ((res + mod) % mod);
    }
}
