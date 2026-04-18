/*
 * Problem: 1572. Matrix Diagonal Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/matrix-diagonal-sum/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            res += mat[i][i] + mat[mat.length - 1 - i][i];
        }
        if (mat.length % 2 == 1)
            res -= mat[mat.length / 2][mat.length / 2];
        return res;
    }
}
