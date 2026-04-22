/*
 * Problem: 1922. Count Good Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-good-numbers/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countGoodNumbers(long n) {
        long res = pow(20, n / 2);
        if (n % 2 == 1)
            res = res * 5 % mod;
        return (int) res;
    }

    int mod = 1_000_000_007;

    public long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1)
                res = (res * a) % mod;
            b /= 2;
            a = (a * a) % mod;
        }
        return res;
    }
}
