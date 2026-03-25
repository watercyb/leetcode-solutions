/*
 * Problem: 74. Search a 2D Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (getNum(matrix, mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l==0) return false;
        return getNum(matrix, l - 1) == target;
    }

    public int getNum(int[][] matrix, int idx) {
        return matrix[idx / matrix[0].length][idx % matrix[0].length];
    }
}
