/*
 * Problem: 562. Longest Line of Consecutive One in Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int longestLine(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        int[] diag = new int[mat[0].length + mat.length];
        int[] diagA = new int[mat[0].length + mat.length];
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    res = Math.max(Math.max(Math.max(++diag[j + mat.length - i],
                            ++diagA[j + i]), Math.max(++cols[j], ++rows[i])), res);
                } else {
                    cols[j] = 0;
                    diag[j + mat.length - i] = 0;
                    diagA[j + i] = 0;
                    rows[i] = 0;
                }
            }
        }
        return res;
    }
}
