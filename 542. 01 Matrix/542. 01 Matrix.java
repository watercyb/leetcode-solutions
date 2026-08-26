/*
 * Problem: 01 Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/01-matrix/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat[0][0] != 0)
            mat[0][0] = Integer.MAX_VALUE / 2;
        for (int i = 1; i < mat[0].length; i++) {
            if (mat[0][i] != 0)
                mat[0][i] = mat[0][i - 1] + 1;
        }
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][0] != 0)
                mat[i][0] = mat[i - 1][0] + 1;
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] != 0)
                    mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + 1;
            }
        }
        for (int i = mat[0].length - 2; i >= 0; i--) {
            if (mat[mat.length - 1][i] != 0)
                mat[mat.length - 1][i] = Math.min(mat[mat.length - 1][i + 1] + 1, mat[mat.length - 1][i]);
        }
        for (int i = mat.length - 2; i >= 0; i--) {
            if (mat[i][mat[0].length - 1] != 0)
                mat[i][mat[0].length - 1] = Math.min(mat[i + 1][mat[0].length - 1] + 1, mat[i][mat[0].length - 1]);
            for (int j = mat[0].length - 2; j >= 0; j--) {
                if (mat[i][j] != 0)
                    mat[i][j] = Math.min(Math.min(mat[i + 1][j], mat[i][j + 1]) + 1, mat[i][j]);
            }
        }
        return mat;
    }
}
