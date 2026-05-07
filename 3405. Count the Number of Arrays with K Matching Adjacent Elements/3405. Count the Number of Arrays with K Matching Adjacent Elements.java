/*
 * Problem: 3405. Count the Number of Arrays with K Matching Adjacent Elements
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int countGoodArrays(int n, int m, int k) {
        return (int) (m * pow(m - 1, n - 1 - k) % mod * C(n - 1, k) % mod);
    }

    int mod = 1_000_000_007;

    public long pow(int a, int b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            b /= 2;
        }
        return res;
    }

    public long C(int a, int b) {
        long res = 1;
        long div = 1;
        if (a - b < b)
            b = a - b;
        for (int i = 1; i <= b; i++) {
            res = res * a % mod;
            div = div * i % mod;
            a--;
        }
        return res * rev(div) % mod;
    }

    public long rev(long a) {
        if (a == 1)
            return a;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
