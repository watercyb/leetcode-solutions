/*
 * Problem: 3619. Count Islands With Total Value Divisible by K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int countIslands(int[][] grid, int k) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && dfs(grid, i, j) % k == 0)
                    res++;
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0)
            return 0;
        int res = grid[i][j];
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] != 0)
            res += dfs(grid, i - 1, j);
        if (i < grid.length - 1 && grid[i + 1][j] != 0)
            res += dfs(grid, i + 1, j);
        if (j > 0 && grid[i][j - 1] != 0)
            res += dfs(grid, i, j - 1);
        if (j < grid[0].length - 1 && grid[i][j + 1] != 0)
            res += dfs(grid, i, j + 1);
        return res;
    }
}
