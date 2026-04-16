/*
 * Problem: 1397. Find All Good Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-all-good-strings/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        int mod = 1_000_000_007;
        if (s1.equals(s2))
            return 0;
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        char[] chrsEvil = evil.toCharArray();
        getLPS(chrsEvil);
        int i = 0;
        int len = 0;
        int l = chrsEvil.length;
        while (chrs1[i] == chrs2[i]) {
            len = getLen(chrsEvil, len, chrs1[i]);
            if (len == l)
                return 0;
            i++;
        }
        int[] edges = { getLen(chrsEvil, len, chrs1[i]), getLen(chrsEvil, len, chrs2[i]) };
        long[] lens = new long[l + 1];
        for (char chr = (char) (chrs1[i] + 1); chr < chrs2[i]; chr++) {
            lens[getLen(chrsEvil, len, chr)]++;
        }
        i++;
        while (i < chrs1.length) {
            long[] lensNext = new long[lens.length];
            if (edges[0] < l) {
                for (char chr = (char) (chrs1[i] + 1); chr <= 'z'; chr++) {
                    lensNext[getLen(chrsEvil, edges[0], chr)]++;
                }
                edges[0] = getLen(chrsEvil, edges[0], chrs1[i]);
            } else {
                lensNext[l] += 'z' - chrs1[i];
            }
            if (edges[1] < l) {
                for (char chr = 'a'; chr < chrs2[i]; chr++) {
                    lensNext[getLen(chrsEvil, edges[1], chr)]++;
                }
                edges[1] = getLen(chrsEvil, edges[1], chrs2[i]);
            } else {
                lensNext[l] += chrs2[i] - 'a';
            }
            for (int j = 0; j < l; j++) {
                if (lens[j] == 0)
                    continue;
                for (char chr = 'a'; chr <= 'z'; chr++) {
                    int lenNext = getLen(chrsEvil, j, chr);
                    lensNext[lenNext] += lens[j];
                }
            }
            lensNext[l] += lens[l] * 26;
            for (int j = 0; j <= l; j++) {
                lensNext[j] %= mod;
            }
            lens = lensNext;
            i++;
        }
        long res = 0;
        for (int j = 0; j < chrs1.length; j++) {
            res = (res * 26 + chrs2[j] - chrs1[j]) % mod;
        }
        res++;
        if (edges[0] == l)
            res--;
        if (edges[1] == l)
            res--;
        res = res - lens[l] + mod;
        return (int) (res % mod);
    }

    int[] LPS;

    public int getLen(char[] chrsEvil, int len, char chr) {
        while (true) {
            if (chr == chrsEvil[len])
                return len + 1;
            if (len > 0) {
                len = LPS[len - 1];
            } else {
                return 0;
            }
        }
    }

    public void getLPS(char[] chrsEvil) {
        LPS = new int[chrsEvil.length];
        int len = 0;
        int idx = 1;
        while (idx < chrsEvil.length) {
            if (chrsEvil[idx] == chrsEvil[len]) {
                len++;
                LPS[idx++] = len;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
    }
}
