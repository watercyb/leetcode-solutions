/*
 * Problem: 1745. Palindrome Partitioning IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindrome-partitioning-iv/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean checkPartitioning(String s) {
        char[] chrs = s.toCharArray();
        boolean[][] isPals = new boolean[chrs.length][chrs.length];
        boolean[][] DP = new boolean[chrs.length + 1][4];
        DP[0][0] = true;
        for (int i = 0; i < chrs.length; i++) {
            isPals[i][i] = true;
            for (int k = 0; k < 3; k++) {
                if (DP[i][k])
                    DP[i + 1][k + 1] = true;
            }
            if (i > 0 && chrs[i - 1] == chrs[i]) {
                isPals[i - 1][i] = true;
                for (int k = 0; k < 3; k++) {
                    if (DP[i - 1][k])
                        DP[i + 1][k + 1] = true;
                }
            }
            for (int j = i - 2; j >= 0; j--) {
                if (chrs[j] == chrs[i] && isPals[j + 1][i - 1]) {
                    isPals[j][i] = true;
                    for (int k = 0; k < 3; k++) {
                        if (DP[j][k])
                            DP[i + 1][k + 1] = true;
                    }
                }
            }
        }
        return DP[DP.length - 1][3];
    }
}
