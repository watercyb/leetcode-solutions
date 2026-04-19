/*
 * Problem: 1631. Path With Minimum Effort
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-with-minimum-effort/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int l = 0;
        int r = 1000000;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (dfs(heights, new boolean[heights.length][heights[0].length], 0, 0, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean dfs(int[][] heights, boolean[][] seens, int i, int j, int mid) {
        if (i == heights.length - 1 && j == heights[0].length - 1)
            return true;
        seens[i][j] = true;
        if (i < heights.length - 1 && !seens[i + 1][j] && Math.abs(heights[i + 1][j] - heights[i][j]) <= mid
                && dfs(heights, seens, i + 1, j, mid))
            return true;
        if (j < heights[0].length - 1 && !seens[i][j + 1] && Math.abs(heights[i][j + 1] - heights[i][j]) <= mid
                && dfs(heights, seens, i, j + 1, mid))
            return true;
        if (i > 0 && !seens[i - 1][j] && Math.abs(heights[i - 1][j] - heights[i][j]) <= mid
                && dfs(heights, seens, i - 1, j, mid))
            return true;
        if (j > 0 && !seens[i][j - 1] && Math.abs(heights[i][j - 1] - heights[i][j]) <= mid
                && dfs(heights, seens, i, j - 1, mid))
            return true;
        return false;
    }
}
