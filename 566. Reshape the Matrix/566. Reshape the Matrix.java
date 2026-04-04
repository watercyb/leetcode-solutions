/*
 * Problem: 566. Reshape the Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reshape-the-matrix/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c || (mat.length == r && mat[0].length == c))
            return mat;
        int[][] res = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[x][y] = mat[i][j];
                if (++y == c) {
                    x++;
                    y = 0;
                }
            }
        }
        return res;
    }
}
