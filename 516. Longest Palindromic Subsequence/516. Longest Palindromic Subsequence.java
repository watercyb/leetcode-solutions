/*
 * Problem: 516. Longest Palindromic Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-palindromic-subsequence/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chrs = s.toCharArray();
        int[] DP = new int[chrs.length + 1];
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            int l = chrs.length - 1 - i;
            int prv = DP[0];
            DP[0] = 0;
            for (int j = 0; j < l; j++) {
                if (chrs[i] == chrs[chrs.length - 1 - j]) {
                    int tmp = DP[j + 1];
                    DP[j + 1] = prv + 2;
                    prv = tmp;
                } else {
                    prv = DP[j + 1];
                    DP[j + 1] = Math.max(DP[j], DP[j + 1]);
                }
            }
            res = Math.max(Math.max(DP[l], prv + 1), res);
        }
        return res;
    }
}
