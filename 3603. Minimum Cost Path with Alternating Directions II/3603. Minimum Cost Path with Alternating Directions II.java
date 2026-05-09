/*
 * Problem: 3603. Minimum Cost Path with Alternating Directions II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-path-with-alternating-directions-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        long[] DP = new long[n];
        Arrays.fill(DP, Long.MAX_VALUE / 2);
        DP[0] = 0;
        for (int i = 0; i < m; i++) {
            long prv = Long.MAX_VALUE / 2;
            for (int j = 0; j < n; j++) {
                DP[j] = Math.min(prv, DP[j]) + waitCost[i][j] + (i + 1) * (j + 1);
                prv = DP[j];
            }
        }
        return DP[n - 1]  - waitCost[0][0]- waitCost[m - 1][n - 1];
    }
}
