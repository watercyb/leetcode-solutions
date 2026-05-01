/*
 * Problem: 2851. String Transformation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/string-transformation/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    int mod = 1_000_000_007;

    public int numberOfWays(String s, String t, long k) {
        char[] chrsS = s.toCharArray();
        char[] chrsT = t.toCharArray();
        int equal0 = -1;
        int equal1 = chrsT.length;
        for (int i = 0; i < chrsT.length; i++) {
            if (chk(chrsS, chrsT, i)) {
                if (equal0 == -1) {
                    equal0 = i;
                } else {
                    equal1 = i;
                    break;
                }
            }
        }
        if (equal0 == -1)
            return 0;
        int sum0 = 0;
        int sum1 = 0;
        for (int i = equal0; i < chrsT.length; i += equal1 - equal0) {
            if (i == 0) {
                sum0++;
            } else {
                sum1++;
            }
        }
        long a = 1;
        int b = 1;
        if (k % 2 == 1)
            b = -1;
        long c = chrsT.length - 1;
        if (k > 1 && c != 1) {
            a = (long) ((pow(c, k) - b) * ModuleInverse((c + 1) % mod) % mod);
        } else if (c == 1) {
            if (b == -1) {
                a = 1;
            } else {
                a = 0;
            }
        }
        return (int) (((a + b) * sum0 + a * sum1) % mod);
    }

    public long pow(long c, long k) {
        long res = 1;
        while (k > 0) {
            if (k % 2 == 1)
                res = (res * c) % mod;
            c = (c * c) % mod;
            k /= 2;
        }
        return res;
    }

    public boolean chk(char[] s, char[] t, int i) {
        for (char chr : s) {
            if (t[i] != chr)
                return false;
            i++;
            if (i == t.length)
                i = 0;
        }
        return true;
    }

    public long ModuleInverse(long c) {
        if (c == 1)
            return c;
        return ((mod - mod / c) * ModuleInverse(mod % c)) % mod;
    }
}
