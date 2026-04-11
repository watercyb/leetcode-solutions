/*
 * Problem: 1012. Numbers With Repeated Digits
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/numbers-with-repeated-digits/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int numDupDigitsAtMostN(int n) {
        int[] DP = new int[11];
        char[] chrs = String.valueOf(n).toCharArray();
        boolean[] seens = new boolean[10];
        seens[chrs[0] - '0'] = true;
        DP[0] = 1;
        DP[10] = 1;
        DP[1] = chrs[0] - '1';
        for (int i = 1; i < chrs.length; i++) {
            int digit = chrs[i] - '0';
            int[] DPNext = new int[11];
            DPNext[0] = DP[0];
            if (seens[digit]) {
                DPNext[10] = 0;
            } else {
                seens[digit] = true;
                DPNext[10] = DP[10];
            }
            if (DP[10] != 0) {
                for (int j = 0; j < digit; j++) {
                    if (!seens[j])
                        DPNext[i + 1] += DP[10];
                }
            }
            DPNext[1] += DP[0] * 9;
            for (int j = 1; j < 9; j++) {
                DPNext[j + 1] += DP[j] * (10 - j);
            }
            DP = DPNext;
        }
        int count = 0;
        for (int i = 0; i < DP.length; i++) {
            count += DP[i];
        }
        return n + 1 - count;
    }
}
