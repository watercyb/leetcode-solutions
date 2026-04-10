/*
 * Problem: 980. Unique Paths III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/unique-paths-iii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1)
                    count++;
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        dfs(grid, x, y, count - 1);
        return res;
    }

    int res = 0;

    public void dfs(int[][] grid, int i, int j, int n) {
        if (n == 0 && grid[i][j] == 2) {
            res++;
            return;
        }
        if (n == 0 || grid[i][j] == 2)
            return;
        grid[i][j] = -1;
        if (i > 0 && grid[i - 1][j] >=0)
            dfs(grid, i - 1, j, n - 1);
        if (i < grid.length - 1 && grid[i + 1][j] >= 0)
            dfs(grid, i + 1, j, n - 1);
        if (j > 0 && grid[i][j - 1] >= 0)
            dfs(grid, i, j - 1, n - 1);
        if (j < grid[0].length - 1 && grid[i][j + 1] >= 0)
            dfs(grid, i, j + 1, n - 1);
        grid[i][j] = 0;
    }
}
