/*
 * Problem: 3579. Minimum Steps to Convert String with Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-steps-to-convert-string-with-operations/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minOperations(String word1, String word2) {
        char[] chrs1 = word1.toCharArray();
        char[] chrs2 = word2.toCharArray();
        int[] DP = new int[chrs1.length + 1];
        DP[0] = 0;
        for (int i = 0; i < chrs1.length; i++) {
            DP[i + 1] = Integer.MAX_VALUE / 2;
            for (int j = i; j >= 0; j--) {
                DP[i + 1] = Math.min(DP[j] + getMin(chrs1, chrs2, j, i), DP[i + 1]);
            }
        }
        return DP[DP.length - 1];
    }

    public int getMin(char[] chrs1, char[] chrs2, int l, int r) {
        int res = chk1(chrs1, chrs2, l, r);
        if (res <= 1)
            return res;
        return Math.min(res, chk2(chrs1, chrs2, l, r) + 1);
    }

    public int chk1(char[] chrs1, char[] chrs2, int l, int r) {
        int[] counts = new int[26 * 26];
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (chrs1[i] != chrs2[i]) {
                int a = chrs1[i] - 'a';
                int b = chrs2[i] - 'a';
                int h = b * 26 + a;
                if (counts[h] > 0) {
                    counts[h]--;
                } else {
                    counts[a * 26 + b]++;
                    res++;
                }
            }
        }
        return res;
    }

    public int chk2(char[] chrs1, char[] chrs2, int l, int r) {
        int[] counts = new int[26 * 26];
        int res = 0;
        int idx = r;
        for (int i = l; i <= r; i++) {
            if (chrs1[i] != chrs2[idx]) {
                int a = chrs1[i] - 'a';
                int b = chrs2[idx] - 'a';
                int h = b * 26 + a;
                if (counts[h] > 0) {
                    counts[h]--;
                } else {
                    counts[a * 26 + b]++;
                    res++;
                }
            }
            idx--;
        }
        return res;
    }
}
