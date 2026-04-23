/*
 * Problem: 2022. Convert 1D Array Into 2D Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-1d-array-into-2d-array/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length)
            return new int[0][0];
        int[][] res = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[idx++];
            }
        }
        return res;
    }
}
