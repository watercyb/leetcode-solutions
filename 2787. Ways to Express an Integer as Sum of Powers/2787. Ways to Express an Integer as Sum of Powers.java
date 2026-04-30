/*
 * Problem: 2787. Ways to Express an Integer as Sum of Powers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int numberOfWays(int n, int x) {
        long[] DP = new long[n + 1];
        DP[n] = 1;
        for (int i = 1; i <= n; i++) {
            int p = (int) Math.pow(i, x);
            if (p > n)
                break;
            for (int j = p; j <= n; j++) {
                DP[j - p] += DP[j];
            }
        }
        return (int) (DP[0] % 1_000_000_007);
    }
}
