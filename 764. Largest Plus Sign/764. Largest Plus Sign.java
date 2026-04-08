/*
 * Problem: 764. Largest Plus Sign
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-plus-sign/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] row : grid) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            int prv = 1;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    prv = 1;
                } else {
                    grid[i][j] = Math.min(prv++, grid[i][j]);
                }
            }
            prv = 1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    prv = 1;
                } else {
                    grid[i][j] = Math.min(prv++, grid[i][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int prv = 1;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 0) {
                    prv = 1;
                } else {
                    grid[j][i] = Math.min(prv++, grid[j][i]);
                }
            }
            prv = 1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[j][i] == 0) {
                    prv = 1;
                } else {
                    res = Math.max(Math.min(prv++, grid[j][i]), res);
                }
            }
        }
        return res;
    }
}
