/*
 * Problem: 1289. Minimum Falling Path Sum II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[] min = { 0, 0, 0 };
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] minNext = { Integer.MAX_VALUE, Integer.MAX_VALUE, 0 };
            for (int j = 0; j < grid[0].length; j++) {
                if (j == min[2]) {
                    sum = grid[i][j] + min[1];
                } else {
                    sum = grid[i][j] + min[0];
                }
                if (sum >= minNext[1])
                    continue;
                if (sum < minNext[0]) {
                    minNext[1] = minNext[0];
                    minNext[0] = sum;
                    minNext[2] = j;
                } else {
                    minNext[1] = sum;
                }
            }
            min = minNext;
        }
        return min[0];
    }
}
