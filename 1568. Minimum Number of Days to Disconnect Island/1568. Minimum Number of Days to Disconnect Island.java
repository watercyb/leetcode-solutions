/*
 * Problem: 1568. Minimum Number of Days to Disconnect Island
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minDays(int[][] grid) {
        int[][] times = new int[grid.length][grid[0].length];
        boolean seen = false;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (times[i][j] == 0) {
                        if (seen)
                            return 0;
                        seen = true;
                        time = 1;
                        dfs(grid, times, i, j);
                    }
                }
            }
        }
        if (count <= 2)
            return count;
        if (found)
            return 1;
        return 2;
    }

    int time = 1;
    boolean found = false;

    public int dfs(int[][] grid, int[][] times, int i, int j) {
        times[i][j] = time;
        int count = 1;
        int res = time++;
        if (i > 0 && grid[i - 1][j] == 1) {
            if (times[i - 1][j] != 0) {
                if (times[i - 1][j] != times[i][j] - 1)
                    res = times[i - 1][j];
            } else {
                int min = dfs(grid, times, i - 1, j);
                if (min > times[i][j] || (times[i][j] > 1 && min == times[i][j])) {
                    found = true;
                }
                res = min;
            }
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            if (times[i + 1][j] != 0) {
                if (times[i + 1][j] != times[i][j] - 1)
                    res = Math.min(times[i + 1][j], res);
            } else {
                int min = dfs(grid, times, i + 1, j);
                if (min > times[i][j] || (times[i][j] > 1 && min == times[i][j])) {
                    found = true;
                }
                res = Math.min(min, res);
            }
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            if (times[i][j - 1] != 0) {
                if (times[i][j - 1] != times[i][j] - 1)
                    res = Math.min(times[i][j - 1], res);
            } else {
                int min = dfs(grid, times, i, j - 1);
                if (min > times[i][j] || (times[i][j] > 1 && min == times[i][j])) {
                    found = true;
                }
                res = Math.min(min, res);
            }
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            if (times[i][j + 1] != 0) {
                if (times[i][j + 1] != times[i][j] - 1)
                    res = Math.min(times[i][j + 1], res);
            } else {
                int min = dfs(grid, times, i, j + 1);
                if (min > times[i][j] || (times[i][j] > 1 && min == times[i][j])) {
                    found = true;
                }
                res = Math.min(min, res);
            }
        }
        return res;
    }
}
