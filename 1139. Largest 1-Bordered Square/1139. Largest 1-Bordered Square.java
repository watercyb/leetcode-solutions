/*
 * Problem: 1139. Largest 1-Bordered Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-1-bordered-square/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] grid1 = new int[grid.length + 1][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = ++sum;
                    grid1[i + 1][j] = grid1[i][j] + 1;
                } else {
                    sum = 0;
                }
            }
        }
        int res = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                int lim = Math.min(grid[i][j], grid1[i + 1][j]);
                for (int k = lim; k >= res + 1; k--) {
                    if (grid[i - k + 1][j] >= k && grid1[i + 1][j - k + 1] >= k) {
                        res = k;
                        break;
                    }
                }
            }
        }
        return res * res;
    }
}
