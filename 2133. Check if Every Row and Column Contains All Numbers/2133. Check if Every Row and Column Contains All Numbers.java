/*
 * Problem: 2133. Check if Every Row and Column Contains All Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean[] seens = new boolean[matrix.length + 1];
            for (int j = 0; j < matrix[0].length; j++) {
                if (seens[matrix[i][j]])
                    return false;
                seens[matrix[i][j]] = true;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            boolean[] seens = new boolean[matrix.length + 1];
            for (int i = 0; i < matrix.length; i++) {
                if (seens[matrix[i][j]])
                    return false;
                seens[matrix[i][j]] = true;
            }
        }
        return true;
    }
}
