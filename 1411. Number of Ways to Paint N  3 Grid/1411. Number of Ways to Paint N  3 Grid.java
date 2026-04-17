/*
 * Problem: 1411. Number of Ways to Paint N × 3 Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int numOfWays(int n) {
        int mod = 1_000_000_007;
        long a = 6;
        long b = 6;
        for (int i = 1; i < n; i++) {
            long temp = a;
            a = (a * 2 + b * 2) % mod;
            b = (temp * 2 + b * 3) % mod;
        }
        return (int) ((a + b) % mod);
    }
}
