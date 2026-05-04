/*
 * Problem: 48. Rotate Image
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotate-image/?envType=daily-question&envId=2026-05-04
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length - 1;
        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = i; j < matrix[0].length - 1 - i; j++) {
                int[][] points = { { i, j }, { j, l - i },
                        { l - i, l - j }, { l - j, i } };
                int tmp = matrix[points[0][0]][points[0][1]];
                matrix[points[0][0]][points[0][1]] = matrix[points[3][0]][points[3][1]];
                matrix[points[3][0]][points[3][1]] = matrix[points[2][0]][points[2][1]];
                matrix[points[2][0]][points[2][1]] = matrix[points[1][0]][points[1][1]];
                matrix[points[1][0]][points[1][1]] = tmp;
            }
        }
    }
}
