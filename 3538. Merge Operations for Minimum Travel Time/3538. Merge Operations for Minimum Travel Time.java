/*
 * Problem: 3538. Merge Operations for Minimum Travel Time
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/merge-operations-for-minimum-travel-time/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        int[][][] DP = new int[n][k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(DP[0][i], Integer.MAX_VALUE / 2);
        }
        DP[0][0][0] = 0;
        int[][] sums = new int[n][k + 1];
        sums[0][0] = time[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(DP[i][j], Integer.MAX_VALUE / 2);
            }
            for (int j = 0; j <= Math.min(k, i - 1); j++) {
                for (int r = 0; r <= j; r++) {
                    DP[i][0][j] = Math.min(DP[i - 1][r][j] + sums[i - 1][r] * (position[i] - position[i - 1]),
                            DP[i][0][j]);
                }
            }
            sums[i][0] = time[i];
            for (int j = i - 1; j >= Math.max(i - k, 1); j--) {
                sums[i][i - j] = sums[i][i - j - 1] + time[j];
                for (int r = i - j; r <= k; r++) {
                    for (int s = 0; s <= r - i + j; s++) {
                        DP[i][i - j][r] = Math.min(
                                DP[j - 1][s][r - i + j] + sums[j - 1][s] * (position[i] - position[j - 1]),
                                DP[i][i - j][r]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(DP[n - 1][i][k], res);
        }
        return res;
    }
}
