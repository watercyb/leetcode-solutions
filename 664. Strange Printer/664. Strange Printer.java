/*
 * Problem: 664. Strange Printer
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/strange-printer/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int strangePrinter(String s) {
        char[] chrs = s.toCharArray();
        int l = 1;
        int r = 1;
        while (r < chrs.length) {
            while (r < chrs.length && chrs[r] == chrs[l - 1]) {
                r++;
            }
            if (r < chrs.length) {
                chrs[l++] = chrs[r++];
            }
        }
        int[][] DP = new int[l + 1][l + 1];
        int[][] arr = new int['z' + 1][];
        int[] idx = new int['z' + 1];
        for (int i = 'a'; i <= 'z'; i++) {
            arr[i] = new int[l];
        }
        for (int i = 0; i < l; i++) {
            for (int j = i; j >= 0; j--) {
                if (j != 0 && chrs[i] == chrs[j - 1]) {
                    DP[i + 1][j] = DP[i][j];
                } else {
                    DP[i + 1][j] = DP[i][j] + 1;
                    for (int k = idx[chrs[i]] - 1; k >= 0 && arr[chrs[i]][k] > j; k--) {
                        DP[i + 1][j] = Math.min(DP[i + 1][arr[chrs[i]][k]] + DP[arr[chrs[i]][k]][j],
                                DP[i + 1][j]);
                    }
                }
            }
            arr[chrs[i]][idx[chrs[i]]++] = i + 1;
        }
        return DP[l][0];
    }
}
