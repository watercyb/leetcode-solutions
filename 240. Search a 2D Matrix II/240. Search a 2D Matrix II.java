/*
 * Problem: 240. Search a 2D Matrix II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
