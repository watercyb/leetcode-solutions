/*
 * Problem: 1830. Minimum Number of Operations to Make String Sorted
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int makeStringSorted(String s) {
        if (f[0] == 0)
            getF();
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        long pR = 1;
        long res = 0;
        for (int i = chrs.length - 1; i >= 0; i--) {
            int idx = chrs[i] - 'a';
            pR = pR * f[counts[idx]] % mod * fR[++counts[idx]] % mod;
            int countPre = 0;
            for (int j = 0; j < idx; j++) {
                countPre += counts[j];
            }
            res = (res + f[chrs.length - i - 1] * countPre % mod * pR % mod) % mod;
        }
        return (int) res;
    }

    int mod = 1_000_000_007;
    static long[] f = new long[3001];
    static long[] fR = new long[3001];

    public void getF() {
        f[0] = 1;
        fR[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = f[i - 1] * i % mod;
            fR[i] = fR[i - 1] * rev(i) % mod;
        }
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
