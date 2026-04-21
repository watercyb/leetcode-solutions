/*
 * Problem: 1808. Maximize Number of Nice Divisors
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-number-of-nice-divisors/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 4)
            return primeFactors;
        int mod = 1_000_000_007;
        int a = primeFactors / 3;
        int b = primeFactors % 3;
        long res = 1;
        if (b == 1) {
            res = 4;
            a--;
        } else if (b > 1) {
            res = b;
        }
        long base = 3;
        while (a > 0) {
            if ((a & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            a /= 2;
        }
        return (int) res;
    }
}
