/*
 * Problem: 2617. Minimum Number of Visited Cells in a Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-visited-cells-in-a-grid/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int[][] DP = new int[grid.length][grid[0].length];
        for (int[] row : DP) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        DP[0][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (DP[i][j] == Integer.MAX_VALUE)
                    continue;
                int lim = j + 1;
                if (j > 0 && DP[i][j] >= DP[i][j - 1])
                    lim = grid[i][j - 1] + j;
                for (int k = Math.min(grid[i][j] + j, grid[0].length - 1); k >= lim; k--) {
                    DP[i][k] = Math.min(DP[i][j] + 1, DP[i][k]);
                }
                lim = i + 1;
                if (i > 0 && DP[i][j] >= DP[i - 1][j])
                    lim = grid[i - 1][j] + i;
                for (int k = Math.min(grid[i][j] + i, grid.length - 1); k >= lim; k--) {
                    DP[k][j] = Math.min(DP[i][j] + 1, DP[k][j]);
                }
            }
        }
        if (DP[grid.length - 1][grid[0].length - 1] == Integer.MAX_VALUE)
            return -1;
        return DP[grid.length - 1][grid[0].length - 1];
    }
}
