/*
 * Problem: 4105. Repeated String Match II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/repeated-string-match-ii/
 * Language: java
 * Date: 2026-11-09
 */

class Solution {
    public boolean repeatedStringMatch(String a, String b, int x, int y) {
        char[] chrsA = a.toCharArray();
        char[] chrsB = b.toCharArray();
        long lenA = (long) chrsA.length * x;
        long lenB = (long) chrsB.length * y;
        if (lenA < lenB)
            return false;
        long l = 0;
        long r = lenB - 1;
        long h = pow(getH(chrsA, 26), (r + 1) / chrsA.length);
        for (long i = chrsA.length * ((r + 1) / chrsA.length); i <= r; i++) {
            int idx = (int) (i % chrsA.length);
            h = (h * 26 + chrsA[idx] - 'a') % mod;
        }
        long t = pow(getH(chrsB, 26), y);
        if (h == t)
            return true;
        long base = pow(26, r);
        r++;
        while (l < chrsA.length && r < lenA) {
            h = (((h - (chrsA[(int) (l % chrsA.length)] - 'a') * base) % mod + mod) * 26
                    + chrsA[(int) (r % chrsA.length)] - 'a') % mod;
            if (h == t)
                return true;
            l++;
            r++;
        }
        return false;
    }

    int mod = 1_000_000_007;

    public long[] getH(char[] a, int b) {
        long res = 0;
        long base = 1;
        for (char chr : a) {
            res = (res * b + chr - 'a') % mod;
            base = (base * b) % mod;
        }
        return new long[] { res, base };
    }

    public long pow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return res;
    }

    public long pow(long[] pair, long n) {
        long resA = 0;
        long baseA = pair[0];
        long baseB = pair[1];
        while (n > 0) {
            if ((n & 1) == 1)
                resA = (resA * baseB + baseA) % mod;
            baseA = (baseA * baseB + baseA) % mod;
            baseB = baseB * baseB % mod;
            n >>= 1;
        }
        return resA;
    }
}
