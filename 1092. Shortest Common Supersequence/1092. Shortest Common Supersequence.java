/*
 * Problem: 1092. Shortest Common Supersequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-common-supersequence/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        int[][] DP = new int[chrs1.length + 1][chrs2.length + 1];
        for (int i = 0; i < chrs1.length; i++) {
            for (int j = 0; j < chrs2.length; j++) {
                if (chrs1[i] == chrs2[j]) {
                    DP[i + 1][j + 1] = DP[i][j] + 1;
                } else {
                    DP[i + 1][j + 1] = Math.max(DP[i][j + 1], DP[i + 1][j]);
                }
            }
        }
        StringBuilder SB = new StringBuilder();
        int x = chrs1.length;
        int y = chrs2.length;
        while (x != 0 && y != 0) {
            if (chrs1[x - 1] == chrs2[y - 1]) {
                SB.append(chrs1[x - 1]);
                x--;
                y--;
            } else if (DP[x][y] == DP[x - 1][y]) {
                SB.append(chrs1[x - 1]);
                x--;
            } else {
                SB.append(chrs2[y - 1]);
                y--;
            }
        }
        while (x > 0) {
            SB.append(chrs1[--x]);
        }
        while (y > 0) {
            SB.append(chrs2[--y]);
        }
        return SB.reverse().toString();
    }
}
