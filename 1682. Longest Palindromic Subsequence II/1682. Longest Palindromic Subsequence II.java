/*
 * Problem: 1682. Longest Palindromic Subsequence II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-palindromic-subsequence-ii/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chrs = s.toCharArray();
        int[][] DP = new int[chrs.length][chrs.length];
        int[][] indexes = new int[chrs.length][chrs.length];
        for (int[] row : indexes) {
            Arrays.fill(row, -1);
        }
        for (int j = 1; j < chrs.length; j++) {
            if (chrs[j] == chrs[j - 1]) {
                DP[j][j - 1] = 2;
                indexes[j][j - 1] = chrs[j] - 'a';
            }
            for (int i = j - 2; i >= 0; i--) {
                if (DP[j - 1][i] > DP[j][i]) {
                    indexes[j][i] = indexes[j - 1][i];
                    DP[j][i] = DP[j - 1][i];
                }
                if (DP[j][i + 1] > DP[j][i]) {
                    indexes[j][i] = indexes[j][i + 1];
                    DP[j][i] = DP[j][i + 1];
                }
                if (chrs[i] == chrs[j] && indexes[j - 1][i + 1] != chrs[i] - 'a') {
                    indexes[j][i] = chrs[i] - 'a';
                    DP[j][i] = DP[j - 1][i + 1] + 2;
                }
            }
        }
        return DP[DP.length - 1][0];
    }
}
