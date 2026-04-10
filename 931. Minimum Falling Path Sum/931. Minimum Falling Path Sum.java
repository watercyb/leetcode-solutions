/*
 * Problem: 931. Minimum Falling Path Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-falling-path-sum/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
            for (int j = 1; j < matrix[0].length - 1; j++) {
                matrix[i][j] += Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i - 1][j + 1]);
            }
            matrix[i][matrix[0].length - 1] += Math.min(matrix[i - 1][matrix[0].length - 1],
                    matrix[i - 1][matrix[0].length - 2]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            res = Math.min(matrix[matrix.length - 1][i], res);
        }
        return res;
    }
}
