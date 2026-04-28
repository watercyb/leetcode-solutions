/*
 * Problem: 2596. Check Knight Tour Configuration
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-knight-tour-configuration/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        int[] x = new int[grid.length * grid[0].length];
        int[] y = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                x[grid[i][j]] = i;
                y[grid[i][j]] = j;
            }
        }
        for (int i = 1; i < x.length; i++) {
            if (Math.abs((x[i] - x[i - 1]) * (y[i] - y[i - 1])) != 2)
                return false;
        }
        return true;
    }
}
