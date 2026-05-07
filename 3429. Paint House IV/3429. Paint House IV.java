/*
 * Problem: 3429. Paint House IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/paint-house-iv/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minCost(int n, int[][] cost) {
        int mid = cost.length / 2;
        long[][] DP = { { Long.MAX_VALUE / 2, cost[mid - 1][0] + cost[mid][1], cost[mid - 1][0] + cost[mid][2] },
                { cost[mid - 1][1] + cost[mid][0], Long.MAX_VALUE / 2, cost[mid - 1][1] + cost[mid][2] },
                { cost[mid - 1][2] + cost[mid][0], cost[mid - 1][2] + cost[mid][1], Long.MAX_VALUE / 2 } };
        for (int i = mid + 1; i < cost.length; i++) {
            int j = cost.length - 1 - i;
            long[][] DPNext = new long[3][3];
            for (long[] row : DPNext) {
                Arrays.fill(row, Long.MAX_VALUE / 2);
            }
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (k == l)
                        continue;
                    for (int p = 0; p < 3; p++) {
                        if (p == k)
                            continue;
                        for (int q = 0; q < 3; q++) {
                            if (p == q || q == l)
                                continue;
                            DPNext[k][l] = Math.min(DP[p][q], DPNext[k][l]);
                        }
                    }
                    DPNext[k][l] += cost[j][k] + cost[i][l];
                }
            }
            DP = DPNext;
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res = Math.min(DP[i][j], res);
            }
        }
        return res;
    }
}
