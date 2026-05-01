/*
 * Problem: 2852. Sum of Remoteness of All Cells
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-remoteness-of-all-cells/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long sumRemoteness(int[][] grid) {
        long sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) {
                    sum += grid[i][j];
                }
            }
        }
        long res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) {
                    count = 0;
                    res += (sum - dfs(grid, i, j)) * count;
                }
            }
        }
        return res;
    }

    int count = 0;

    public long dfs(int[][] grid, int i, int j) {
        long res = grid[i][j];
        grid[i][j] = -1;
        count++;
        if (i > 0 && grid[i - 1][j] != -1) {
            res += dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] != -1) {
            res += dfs(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] != -1) {
            res += dfs(grid, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] != -1) {
            res += dfs(grid, i, j + 1);
        }
        return res;
    }
}
