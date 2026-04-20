/*
 * Problem: 1771. Maximize Palindrome Length From Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int longestPalindrome(String word1, String word2) {
        int lim = word1.length();
        char[] chrs = new StringBuilder(word1).append(word2).toString().toCharArray();
        int[][] DP = new int[chrs.length + 1][chrs.length];
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            DP[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (chrs[j] == chrs[i]) {
                    DP[j][i] = DP[j + 1][i - 1] + 2;
                    if (j < lim && i >= lim)
                        res = Math.max(res, DP[j][i]);
                } else {
                    DP[j][i] = Math.max(DP[j + 1][i], DP[j][i - 1]);
                }
            }
        }
        return res;
    }
}
