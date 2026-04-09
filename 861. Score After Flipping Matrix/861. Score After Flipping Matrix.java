/*
 * Problem: 861. Score After Flipping Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/score-after-flipping-matrix/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        int res = grid.length;
        for (int i = 1; i < grid[0].length; i++) {
            int count = 0;
            for (int j = 0; j < grid.length; j++) {
                count += grid[j][i];
            }
            res *= 2;
            res += Math.max(grid.length - count, count);
        }
        return res;
    }
}
