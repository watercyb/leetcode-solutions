/*
 * Problem: 1866. Number of Ways to Rearrange Sticks With K Sticks Visible
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int rearrangeSticks(int n, int k) {
        int mod = 1_000_000_007;
        long[] DP = new long[k + 2];
        DP[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = Math.min(k, i + 1); j >= 1; j--) {
                DP[j] = (DP[j] * i + DP[j - 1]) % mod;
            }
        }
        return (int) DP[k];
    }
}
