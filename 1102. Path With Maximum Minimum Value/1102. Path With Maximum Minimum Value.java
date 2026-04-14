/*
 * Problem: 1102. Path With Maximum Minimum Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-with-maximum-minimum-value/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int l = 0;
        int r = Math.min(grid[0][0], grid[grid.length - 1][grid[0].length - 1]);
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (!dfs(new boolean[grid.length][grid[0].length], grid, 0, 0, mid)) {
                r = mid - 1;
            } else {
                l = mid;
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
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[i][j] >= lim && !seens[x][y]) {
                seens[x][y] = true;
                if (dfs(seens, grid, x, y, lim))
                    return true;
            }
        }
        return false;
    }
}
