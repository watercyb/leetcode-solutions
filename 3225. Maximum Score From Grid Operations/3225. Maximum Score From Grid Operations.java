/*
 * Problem: 3225. Maximum Score From Grid Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-from-grid-operations/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] sums = new long[grid.length][grid.length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                sums[i][j + 1] = sums[i][j] + grid[j][i];
            }
        }
        long[] DP1 = new long[n + 1];
        long[] DP2 = new long[n + 1];
        for (int i = 1; i < grid.length; i++) {
            long[] DP1Next = new long[n + 1];
            long[] DP2Next = new long[n + 1];
            long max = 0;
            for (int j = 0; j <= n; j++) {
                max = Math.max(DP1[j], max);
                DP1Next[j] = max;
                DP2Next[j] = max;
            }
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < j; k++) {
                    DP1Next[k] = Math.max(DP1[j] + sums[i][j] - sums[i][k], DP1Next[k]);
                }
                for (int k = j + 1; k <= n; k++) {
                    long sum = DP2[j] + sums[i - 1][k] - sums[i - 1][j];
                    DP1Next[k] = Math.max(sum, DP1Next[k]);
                    DP2Next[k] = Math.max(sum, DP2Next[k]);
                }
            }
            DP1 = DP1Next;
            DP2 = DP2Next;
        }
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res = Math.max(DP1[i], res);
        }
        return res;
    }
}
