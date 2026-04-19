/*
 * Problem: 1605. Find Valid Matrix Given Row and Column Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int i = 0;
        int j = 0;
        while (i < rowSum.length && j < colSum.length) {
            if (rowSum[i] == colSum[j]) {
                res[i][j] = rowSum[i];
                i++;
                j++;
            } else if (rowSum[i] > colSum[j]) {
                res[i][j] = colSum[j];
                rowSum[i] -= colSum[j];
                j++;
            } else {
                res[i][j] = rowSum[i];
                colSum[j] -= rowSum[i];
                i++;
            }
        }
        return res;
    }
}
