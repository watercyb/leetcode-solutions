/*
 * Problem: 1706. Where Will the Ball Fall
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/where-will-the-ball-fall/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = dfs(grid, 0, i);
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x == grid.length)
            return y;
        if (grid[x][y] == 1) {
            if (y == grid[0].length - 1 || grid[x][y + 1] == -1)
                return -1;
            return dfs(grid, x + 1, y + 1);
        } else {
            if (y == 0 || grid[x][y - 1] == 1)
                return -1;
            return dfs(grid, x + 1, y - 1);
        }
    }
}
