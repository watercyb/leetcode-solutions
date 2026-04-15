/*
 * Problem: 1219. Path with Maximum Gold
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-with-maximum-gold/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    break;
                count++;
                sum += grid[i][j];
            }
        }
        if (count == grid.length * grid[0].length)
            return sum;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(dfs(grid, new boolean[grid.length][grid[0].length], i, j), res);
            }
        }
        return res;
    }

    public int dfs(int[][] grid, boolean[][] seens, int i, int j) {
        seens[i][j] = true;
        int res = 0;
        if (i < grid.length - 1 && !seens[i + 1][j] && grid[i + 1][j] != 0)
            res = Math.max(dfs(grid, seens, i + 1, j), res);
        if (i > 0 && !seens[i - 1][j] && grid[i - 1][j] != 0)
            res = Math.max(dfs(grid, seens, i - 1, j), res);
        if (j < grid[0].length - 1 && !seens[i][j + 1] && grid[i][j + 1] != 0)
            res = Math.max(dfs(grid, seens, i, j + 1), res);
        if (j > 0 && !seens[i][j - 1] && grid[i][j - 1] != 0)
            res = Math.max(dfs(grid, seens, i, j - 1), res);
        seens[i][j] = false;
        return res + grid[i][j];
    }
}
