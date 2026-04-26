/*
 * Problem: 2319. Check if Matrix Is X-Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-matrix-is-x-matrix/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0)
                return false;
            grid[i][i] = 0;
            if (2 * i != n - 1 && grid[i][n - i - 1] == 0)
                return false;
            grid[i][n - i - 1] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
}
