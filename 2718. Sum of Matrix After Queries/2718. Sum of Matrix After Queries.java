/*
 * Problem: 2718. Sum of Matrix After Queries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-matrix-after-queries/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        int row = n;
        int col = n;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        long res = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            if (queries[i][0] == 0) {
                if (!rows[queries[i][1]]) {
                    rows[queries[i][1]] = true;
                    res += (long) row * queries[i][2];
                    col--;
                }
            } else {
                if (!cols[queries[i][1]]) {
                    cols[queries[i][1]] = true;
                    res += (long) col * queries[i][2];
                    row--;
                }
            }
        }
        return res;
    }
}
