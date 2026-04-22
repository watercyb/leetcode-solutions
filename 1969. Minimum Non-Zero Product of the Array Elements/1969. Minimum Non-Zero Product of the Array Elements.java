/*
 * Problem: 1969. Minimum Non-Zero Product of the Array Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minNonZeroProduct(int p) {
        long a = (pow(2, p) - 1) % mod;
        return (int) (pow_2(a - 1, p - 1) * a % mod);
    }

    int mod = 1_000_000_007;

    public long pow_2(long a, int b) {
        long res = 1;
        while (b > 0) {
            res = res * a % mod;
            a = a * a % mod;
            b--;
        }
        return res;
    }

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
}
