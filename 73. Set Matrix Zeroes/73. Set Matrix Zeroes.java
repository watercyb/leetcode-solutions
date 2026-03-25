/*
 * Problem: 73. Set Matrix Zeroes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int a = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        a = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || (i == 0 && a == 0) || (i > 0 && matrix[i][0] == 0))
                    matrix[i][j] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (a == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
