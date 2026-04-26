/*
 * Problem: 2373. Largest Local Values in a Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-local-values-in-a-matrix/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                int tmp = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        tmp = Math.max(grid[k][l], tmp);
                    }
                }
                res[i][j] = tmp;
            }
        }
        return res;
    }
}
