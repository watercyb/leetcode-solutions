/*
 * Problem: 2328. Number of Increasing Paths in a Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int countPaths(int[][] grid) {
        long[][] meme = new long[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (meme[i][j] == 0)
                    dfs(grid, meme, i, j);
            }
        }
        return (int) res;
    }

    int mod = 1_000_000_007;
    long res = 0;

    public long dfs(int[][] grid, long[][] meme, int i, int j) {
        if (meme[i][j] != 0)
            return meme[i][j];
        long count = 1;
        if (i > 0 && grid[i - 1][j] < grid[i][j]) {
            count += dfs(grid, meme, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] < grid[i][j]) {
            count += dfs(grid, meme, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] < grid[i][j]) {
            count += dfs(grid, meme, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] < grid[i][j]) {
            count += dfs(grid, meme, i, j + 1);
        }
        res = (res + count) % mod;
        return meme[i][j] = count % mod;
    }
}
