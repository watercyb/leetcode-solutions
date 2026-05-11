/*
 * Problem: 3855. Sum of K-Digit Numbers in a Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-k-digit-numbers-in-a-range/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int sumOfNumbers(int l, int r, int k) {
        return (int) ((pow(10, k) - 1 + mod) * rev(9) % mod * pow(r - l + 1, k - 1) % mod * (l + r) * (r - l + 1) / 2
                % mod);
    }

    int mod = 1_000_000_007;

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }

    public long pow(int a, int b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            b >>= 1;
        }
        return res;
    }
}
