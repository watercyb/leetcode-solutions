/*
 * Problem: 2304. Minimum Path Cost in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-path-cost-in-a-grid/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid[0].length;
        int[] DP = new int[n];
        for (int i = 0; i < grid[0].length; i++) {
            DP[i] = grid[0][i];
        }
        for (int i = 0; i < grid.length - 1; i++) {
            int[] DPNext = new int[n];
            for (int k = 0; k < grid[0].length; k++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < grid[0].length; j++) {
                    min = Math.min(min, DP[j] + moveCost[grid[i][j]][k]);
                }
                DPNext[k] = min + grid[i + 1][k];
            }
            DP = DPNext;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < DP.length; i++) {
            res = Math.min(res, DP[i]);
        }
        return res;
    }
}
