/*
 * Problem: 2312. Selling Pieces of Wood
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/selling-pieces-of-wood/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] DP = new long[m + 1][n + 1];
        for (int[] price : prices) {
            DP[price[0]][price[1]] = price[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                long max = DP[i][j];
                int lim = i / 2;
                for (int k = 1; k <= lim; k++) {
                    max = Math.max(DP[k][j] + DP[i - k][j], max);
                }
                lim = j / 2;
                for (int k = 1; k <= lim; k++) {
                    max = Math.max(DP[i][k] + DP[i][j - k], max);
                }
                DP[i][j] = max;
            }
        }
        return DP[m][n];
    }
}
