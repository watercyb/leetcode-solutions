/*
 * Problem: 2930. Number of Strings Which Can Be Rearranged to Contain Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int stringCount(int n) {
        long res = pow(26, n);
        res -= pow(25, n) * 3 + pow(25, n - 1) * n;
        res += pow(24, n) * 3 + pow(24, n - 1) * 2 * n;
        res -= pow(23, n) + pow(23, n - 1) * n;
        return (int) ((res % mod + mod) % mod);
    }

    int mod = 1_000_000_007;

    public long pow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 > 0)
                res = res * x % mod;
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }
}

