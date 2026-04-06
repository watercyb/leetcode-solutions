/*
 * Problem: 695. Max Area of Island
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-area-of-island/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    res = Math.max(dfs(grid, i, j), res);
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0)
            return 0;
        grid[x][y] = 0;
        int res = 1;
        if (x > 0)
            res += dfs(grid, x - 1, y);
        if (x < grid.length - 1)
            res += dfs(grid, x + 1, y);
        if (y > 0)
            res += dfs(grid, x, y - 1);
        if (y < grid[0].length - 1)
            res += dfs(grid, x, y + 1);
        return res;
    }
}
