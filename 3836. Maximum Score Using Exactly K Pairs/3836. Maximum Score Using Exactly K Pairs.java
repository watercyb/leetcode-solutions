/*
 * Problem: 3836. Maximum Score Using Exactly K Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-using-exactly-k-pairs/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long[][][] DP = new long[nums1.length + 1][nums2.length + 1][k + 1];
        long min = Long.MIN_VALUE / 2;
        for (long[][] matrix : DP) {
            for (long[] row : matrix) {
                Arrays.fill(row, min);
                row[0] = 0;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int lim = Math.min(Math.min(i, j) + 1, k);
                long pro = (long) nums1[i] * nums2[j];
                for (int l = 1; l <= lim; l++) {
                    DP[i + 1][j + 1][l] = Math.max(Math.max(DP[i][j + 1][l], DP[i + 1][j][l]),
                            DP[i][j][l - 1] + pro);
                }
            }
        }
        return DP[nums1.length][nums2.length][k];
    }
}
