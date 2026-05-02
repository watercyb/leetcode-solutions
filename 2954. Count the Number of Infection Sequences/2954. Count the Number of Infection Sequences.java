/*
 * Problem: 2954. Count the Number of Infection Sequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-infection-sequences/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int numberOfSequence(int n, int[] sick) {
        if (f == null) {
            f = new long[100001];
            f[0] = 1;
            r = new long[100001];
            r[0] = 1;
            p = new long[100001];
            p[0] = 1;
            for (int i = 1; i <= 100000; i++) {
                f[i] = f[i - 1] * i % mod;
                r[i] = rev(f[i]);
                p[i] = p[i - 1] * 2 % mod;
            }
        }
        long res = 1;
        int len = n - sick.length;
        for (int i = 1; i < sick.length; i++) {
            int l = sick[i] - sick[i - 1] - 1;
            if (l > 0) {
                res = res * p[l - 1] % mod * C(len, l) % mod;
                len -= l;
            }
        }
        res = res * C(len, sick[0]) % mod;
        return (int) res;
    }

    int mod = 1_000_000_007;
    static long[] f;
    static long[] r;
    static long[] p;

    public long C(int a, int b) {
        if (b == 0)
            return 1;
        return f[a] * r[a - b] % mod * r[b] % mod;
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
