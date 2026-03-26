/*
 * Problem: 200. Number of Islands
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-islands/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public static int numIslands(char[][] grid) {
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    checkIsland(grid, i, j);
                    n++;
                }
            }
        }
        return n;
    }

    public static void checkIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i < grid.length - 1 && grid[i + 1][j] == '1')
            checkIsland(grid, i + 1, j);
        if (i > 0 && grid[i - 1][j] == '1')
            checkIsland(grid, i - 1, j);
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1')
            checkIsland(grid, i, j + 1);
        if (j > 0 && grid[i][j - 1] == '1')
            checkIsland(grid, i, j - 1);
    }
}

