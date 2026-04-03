/*
 * Problem: 378. Kth Smallest Element in a Sorted Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1];
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (chk(matrix, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

    public boolean chk(int[][] matrix, int k, int mid) {
        int count = 0;
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length) {
            while (c >= 0 && matrix[r][c] > mid)
                c--;
            if (c < 0)
                return false;
            count += c + 1;
            if (count >= k)
                return true;

            r++;
        }
        return false;
    }
}
