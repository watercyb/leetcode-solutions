/*
 * Problem: 1692. Count Ways to Distribute Candies
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-ways-to-distribute-candies/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int waysToDistribute(int n, int k) {
        int mod = 1_000_000_007;
        long[] DP = new long[k + 1];
        DP[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = k; j >=1; j--) {
                DP[j] = (DP[j - 1] + j * DP[j]) % mod;
            }
        }
        return (int)DP[k];
    }
}
