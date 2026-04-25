/*
 * Problem: 2266. Count Number of Texts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-texts/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int countTexts(String pressedKeys) {
        int mod = 1_000_000_007;
        char[] chrs = pressedKeys.toCharArray();
        long[] DP = new long[chrs.length + 1];
        DP[0] = 1;
        int[] lims = { 0, 0, 2, 2, 2, 2, 2, 3, 2, 3 };
        for (int i = 0; i < chrs.length; i++) {
            DP[i + 1] = DP[i];
            for (int j = i - 1; j >= Math.max(i - lims[chrs[i] - '0'], 0) && chrs[j] == chrs[i]; j--) {
                DP[i + 1] += DP[j];
            }
            DP[i + 1] %= mod;
        }
        return (int) DP[DP.length - 1];
    }
}
