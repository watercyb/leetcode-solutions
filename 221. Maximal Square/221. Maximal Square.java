/*
 * Problem: 221. Maximal Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximal-square/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int l = matrix[0].length;
        int[][] sums = new int[r + 1][l + 1];
        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < l; j++) {
                sum += matrix[i][j] - '0';
                sums[i + 1][j + 1] = sums[i][j + 1] + sum;
            }
        }
        int left = 1;
        int right = Math.min(r, l) + 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (!chk(sums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (left - 1) * (left - 1);
    }

    public boolean chk(int[][] sums, int mid) {
        int target = mid * mid;
        for (int i = mid - 1; i < sums.length - 1; i++) {
            for (int j = mid - 1; j < sums[0].length - 1; j++) {
                if (sums[i + 1][j + 1] - sums[i + 1][j + 1 - mid] - sums[i + 1 - mid][j + 1]
                        + sums[i + 1 - mid][j + 1 - mid] == target)
                    return true;
            }
        }
        return false;
    }
}
