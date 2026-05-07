/*
 * Problem: 3402. Minimum Operations to Make Columns Strictly Increasing
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int minimumOperations(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int prv = -1;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] <= prv) {
                    prv++;
                    res += prv - grid[j][i];
                } else {
                    prv = grid[j][i];
                }
            }
        }
        return res;
    }
}
