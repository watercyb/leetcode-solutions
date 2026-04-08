/*
 * Problem: 766. Toeplitz Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/toeplitz-matrix/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }
}
