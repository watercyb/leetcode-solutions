/*
 * Problem: 132. Palindrome Partitioning II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindrome-partitioning-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int minCut(String s) {
        char[] chrs = s.toCharArray();
        int[] DP = new int[chrs.length + 1];
        boolean[][] mems = new boolean[chrs.length][chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            DP[i + 1] = DP[i];
            for (int j = 0; j <= i - 1; j++) {
                if (chrs[i] == chrs[j] && (i - j <= 2 || mems[j + 1][i - 1])) {
                    mems[j][i] = true;
                    if (DP[j] < DP[i + 1])
                    DP[i + 1] = DP[j];
                }
            }
            DP[i + 1]++;
        }
        return DP[chrs.length] - 1;
    }
}
