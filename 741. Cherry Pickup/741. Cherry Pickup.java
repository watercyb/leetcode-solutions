/*
 * Problem: 741. Cherry Pickup
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cherry-pickup/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int cherryPickup(int[][] grid) {
        return Math.max(dfs(grid, new int[grid.length][grid.length][grid.length], 0, 0, 0) - 1, 0);
    }

    public int dfs(int[][] grid, int[][][] meme, int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        if (x1 >= grid.length || y1 >= grid.length || x2 >= grid.length || y2 >= grid.length
                || grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return Integer.MIN_VALUE / 2;
        }
        if (x1 == grid.length - 1 && y1 == grid.length - 1)
            return grid[x1][x2] + 1;
        if (meme[x1][y1][x2] != 0)
            return meme[x1][y1][x2];
        int res = Integer.MIN_VALUE / 2;
        res = Math.max(Math.max(
                Math.max(dfs(grid, meme, x1 + 1, y1, x2 + 1),
                        dfs(grid, meme, x1 + 1, y1, x2)),
                Math.max(dfs(grid, meme, x1, y1 + 1, x2 + 1),
                        dfs(grid, meme, x1, y1 + 1, x2))),
                res);
        if (x1 != x2) {
            res += grid[x1][y1] + grid[x2][y2];
        } else {
            res += grid[x1][y1];
        }
        return meme[x1][y1][x2] = res;
    }
}
