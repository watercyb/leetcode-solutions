/*
 * Problem: 1905. Count Sub Islands
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-sub-islands/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j))
                    res++;
            }
        }
        return res;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        grid2[i][j] = 0;
        boolean res = grid1[i][j] == 1;
        if (i > 0 && grid2[i - 1][j] == 1 && !dfs(grid1, grid2, i - 1, j))
            res = false;
        if (i < grid2.length - 1 && grid2[i + 1][j] == 1 && !dfs(grid1, grid2, i + 1, j))
            res = false;
        if (j > 0 && grid2[i][j - 1] == 1 && !dfs(grid1, grid2, i, j - 1))
            res = false;
        if (j < grid2[0].length - 1 && grid2[i][j + 1] == 1 && !dfs(grid1, grid2, i, j + 1))
            res = false;
        return res;
    }
}
