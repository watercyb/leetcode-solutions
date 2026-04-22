/*
 * Problem: 1975. Maximum Matrix Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-matrix-sum/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= 0) {
                    min = Math.min(matrix[i][j], min);
                    sum += matrix[i][j];
                } else {
                    min = Math.min(-matrix[i][j], min);
                    sum -= matrix[i][j];
                    count++;
                }
            }
        }
        if (count % 2 == 0)
            return sum;
        return sum - 2 * min;
    }
}
