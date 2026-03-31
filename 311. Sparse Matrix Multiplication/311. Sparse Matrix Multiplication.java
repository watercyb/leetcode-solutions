/*
 * Problem: 311. Sparse Matrix Multiplication
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sparse-matrix-multiplication/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int k = 0; k < mat2.length; k++) {
                if (mat1[i][k] == 0)
                    continue;
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
}
