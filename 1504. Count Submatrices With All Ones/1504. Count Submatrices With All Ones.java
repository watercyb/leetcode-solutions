/*
 * Problem: 1504. Count Submatrices With All Ones
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-submatrices-with-all-ones/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int numSubmat(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i > 0 && mat[i][j] == 1)
                    mat[i][j] += mat[i - 1][j];
                int min = Integer.MAX_VALUE;
                for (int k = j; k >= 0 && min > 0; k--) {
                    min = Math.min(mat[i][k], min);
                    res += min;
                }
            }
        }
        return res;
    }
}
