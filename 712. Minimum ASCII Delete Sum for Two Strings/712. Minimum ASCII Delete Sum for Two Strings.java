/*
 * Problem: 712. Minimum ASCII Delete Sum for Two Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int[][] DP = new int[chrs1.length + 1][chrs2.length + 1];
        for (int i = 0; i < chrs1.length; i++) {
            DP[i + 1][0] = DP[i][0] + chrs1[i];
        }
        for (int i = 0; i < chrs2.length; i++) {
            DP[0][i + 1] = DP[0][i] + chrs2[i];
        }
        for (int i = 0; i < chrs1.length; i++) {
            for (int j = 0; j < chrs2.length; j++) {
                if (chrs1[i] == chrs2[j]) {
                    DP[i + 1][j + 1] = DP[i][j];
                } else {
                    DP[i + 1][j + 1] = Math.min(DP[i + 1][j] + chrs2[j], DP[i][j + 1] + chrs1[i]);
                }
            }
        }
        return DP[chrs1.length][chrs2.length];
    }
}
