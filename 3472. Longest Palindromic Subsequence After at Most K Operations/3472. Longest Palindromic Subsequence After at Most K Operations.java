/*
 * Problem: 3472. Longest Palindromic Subsequence After at Most K Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        char[] chrs = s.toCharArray();
        int[][][] DP = new int[chrs.length][chrs.length][k + 1];
        for (int i = 1; i < chrs.length; i++) {
            DP[i][i][0] = 1;
            for (int j = i - 1; j >= 0; j--) {
                for (int l = 0; l <= k; l++) {
                    DP[j][i][l] = Math.max(DP[j + 1][i][l], DP[j][i - 1][l]);
                }
                int diff = getDiff(chrs[i], chrs[j]);
                for (int l = 0; l + diff <= k; l++) {
                    DP[j][i][l + diff] = Math.max(DP[j + 1][i - 1][l] + 2, DP[j][i][l + diff]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, DP[0][chrs.length - 1][i]);
        }
        return res;
    }

    public int getDiff(char a, char b) {
        int diff = Math.abs(a - b);
        if (diff > 13)
            diff = 26 - diff;
        return diff;
    }
}
