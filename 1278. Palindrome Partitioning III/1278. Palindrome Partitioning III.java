/*
 * Problem: 1278. Palindrome Partitioning III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindrome-partitioning-iii/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int palindromePartition(String s, int k) {
        char[] chrs = s.toCharArray();
        int[][] DP = new int[chrs.length + 1][k + 1];
        for (int[] row : DP) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        DP[0][0] = 0;
        int[][] steps = new int[chrs.length][chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            for (int l = Math.min(k, i + 1); l >= 1; l--) {
                DP[i + 1][l] = Math.min(DP[i][l - 1], DP[i + 1][l]);
            }
            for (int j = i - 1; j >= 0; j--) {
                steps[j][i] = (chrs[i] == chrs[j] ? 0 : 1) + steps[j + 1][i - 1];
                int count = steps[j][i];
                for (int l = Math.min(k, j + 1); l >= 1; l--) {
                    DP[i + 1][l] = Math.min(DP[j][l - 1] + count, DP[i + 1][l]);
                }
            }
        }
        return DP[DP.length - 1][k];
    }
}
