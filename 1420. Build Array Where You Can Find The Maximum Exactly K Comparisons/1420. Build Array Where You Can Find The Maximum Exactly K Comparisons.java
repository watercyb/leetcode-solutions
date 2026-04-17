/*
 * Problem: 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int numOfArrays(int n, int m, int k) {
        int mod = 1000000007;
        int[][][] DP = new int[n][m + 1][k + 2];
        for (int i = 1; i <= m; i++) {
            DP[0][i][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int l = 1; l <= Math.min(k, i+1); l++) {
                long sum = 0;
                for (int j = 1; j <= m; j++) {
                    DP[i][j][l] = (int) (((long) DP[i][j][l] + (long) DP[i - 1][j][l] * j + sum) % mod);
                    sum += DP[i - 1][j][l - 1];
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= m; i++) {
            res += DP[n - 1][i][k];
        }
        return (int) (res % mod);
    }
}
