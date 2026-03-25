/*
 * Problem: 85. Maximal Rectangle
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximal-rectangle/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            int limLeft = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(limLeft, left[j]);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    limLeft = j + 1;
                }
            }
            int limRight = matrix[0].length;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(limRight, right[j]);
                    res = Math.max((right[j] - left[j]) * height[j], res);
                } else {
                    right[j] = matrix[0].length;
                    limRight = j;
                }
            }
        }
        return res;
    }
}
