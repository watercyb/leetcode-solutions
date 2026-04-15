/*
 * Problem: 1254. Number of Closed Islands
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-closed-islands/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int closedIsland(int[][] grid) {
        int r = grid.length - 1;
        int l = grid[0].length - 1;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0)
                dfs(grid, i, 0);
            if (grid[i][l] == 0)
                dfs(grid, i, l);
        }
        for (int i = 1; i < l; i++) {
            if (grid[0][i] == 0)
                dfs(grid, 0, i);
            if (grid[r][i] == 0)
                dfs(grid, r, i);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 1;
        if (i > 0 && grid[i - 1][j] == 0)
            dfs(grid, i - 1, j);
        if (i < grid.length - 1 && grid[i + 1][j] == 0)
            dfs(grid, i + 1, j);
        if (j > 0 && grid[i][j - 1] == 0)
            dfs(grid, i, j - 1);
        if (j < grid[0].length - 1 && grid[i][j + 1] == 0)
            dfs(grid, i, j + 1);
    }
}
