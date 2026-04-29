/*
 * Problem: 2658. Maximum Number of Fish in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0)
                    res = Math.max(dfs(grid, i, j), res);
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        int res = grid[i][j];
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] != 0) {
            res += dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] != 0) {
            res += dfs(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] != 0) {
            res += dfs(grid, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] != 0) {
            res += dfs(grid, i, j + 1);
        }
        return res;
    }
}
