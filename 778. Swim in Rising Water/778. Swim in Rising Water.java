/*
 * Problem: 778. Swim in Rising Water
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/swim-in-rising-water/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int swimInWater(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        int l = Math.max(grid[0][0], grid[grid.length - 1][grid[0].length - 1]);
        int r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (dfs(new boolean[grid.length][grid[0].length], grid, 0, 0, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int[][] dricts = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean dfs(boolean[][] seens, int[][] grid, int i, int j, int lim) {
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return true;
        for (int[] drict : dricts) {
            int x = i + drict[0];
            int y = j + drict[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] <= lim && !seens[x][y]) {
                seens[x][y] = true;
                if (dfs(seens, grid, x, y, lim))
                    return true;
            }
        }
        return false;
    }
}
