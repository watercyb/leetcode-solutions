/*
 * Problem: 3742. Maximum Path Score in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-path-score-in-a-grid/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        k = Math.min(k, grid.length + grid[0].length - 2);
        int[][] DP = new int[grid[0].length][k + 2];
        for (int[] row : DP) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int score = 0;
        int cost = 0;
        for (int i = 0; i < grid[0].length; i++) {
            score += grid[0][i];
            cost += (grid[0][i] + 1) / 2;
            if (cost <= k)
                DP[i][cost] = score;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int l = k; l >= 0; l--) {
                if (grid[i][0] == 0) {
                    DP[0][l] += grid[i][0];
                } else {
                    DP[0][l + 1] =DP[0][l]+grid[i][0];
                    DP[0][l] = Integer.MIN_VALUE;
                }
            }
            for (int j = 1; j < grid[0].length; j++) {
                for (int l = k; l >= 0; l--) {
                    if (grid[i][j] == 0) {
                        DP[j][l] = Math.max(DP[j - 1][l], DP[j][l]) + grid[i][j];
                    } else {
                        DP[j][l + 1] = Math.max(DP[j - 1][l], DP[j][l]) + grid[i][j];
                        DP[j][l] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, DP[grid[0].length - 1][i]);
        }
        if (res<0) return -1;
        return res;
    }
}
