/*
 * Problem: 1074. Number of Submatrices That Sum to Target
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        byte[] chrs = new byte[20000001];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + matrix[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i + 1; j < matrix[0].length + 1; j++) {
                int[] changed = new int[matrix.length + 1];
                int tmp = 10000000;
                chrs[tmp + target]++;
                changed[0]=tmp + target;
                for (int k = 1; k < matrix.length + 1; k++) {
                    tmp += sum[k][j] - sum[k][i];
                    res += chrs[tmp];
                    chrs[tmp + target]++;
                    changed[k] = tmp + target;
                }
                for (int in : changed) {
                    chrs[in] = 0;
                }
            }
        }
        return res;
    }
}
