/*
 * Problem: 2684. Maximum Number of Moves in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int maxMoves(int[][] grid) {
        boolean[][] DP = new boolean[grid.length + 2][grid[0].length];
        for (int i = 1; i <= grid.length; i++) {
            DP[i][0] = true;
        }
        int res = 0;
        for (int i = 1; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if ((DP[j][i - 1] && grid[j][i] > grid[j - 1][i - 1])
                        || (DP[j + 1][i - 1] && grid[j][i] > grid[j][i - 1])
                        || (DP[j + 2][i - 1] && grid[j][i] > grid[j + 1][i - 1])) {
                    DP[j + 1][i] = true;
                    res = i;
                }
            }
        }
        return res;
    }
}
