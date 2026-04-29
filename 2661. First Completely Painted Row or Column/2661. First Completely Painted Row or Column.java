/*
 * Problem: 2661. First Completely Painted Row or Column
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/first-completely-painted-row-or-column/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] idx = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            idx[arr[i]] = i;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int max = 0;
            for (int j = 0; j < mat[0].length; j++) {
                max = Math.max(idx[mat[i][j]], max);
            }
            res = Math.min(max, res);
        }
        for (int i = 0; i < mat[0].length; i++) {
            int max = 0;
            for (int j = 0; j < mat.length; j++) {
                max = Math.max(idx[mat[j][i]], max);
            }
            res = Math.min(max, res);
        }
        return res;
    }
}
