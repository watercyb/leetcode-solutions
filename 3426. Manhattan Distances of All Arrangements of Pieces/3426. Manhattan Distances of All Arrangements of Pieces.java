/*
 * Problem: 3426. Manhattan Distances of All Arrangements of Pieces
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/manhattan-distances-of-all-arrangements-of-pieces/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int distanceSum(int m, int n, int k) {
        return (int) ((count(m, n, k) + count(n, m, k)) % mod * C(m * n - 2, k - 2) % mod);
    }

    int mod = 1_000_000_007;

    public long count(int m, int n, int k) {
        long res = 0;
        for (int i = 1; i <= m - 1; i++) {
            res += (long) (m - i) * i;
        }
        return res % mod * n % mod * n;
    }

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        long div = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a % mod;
            div = div * i % mod;
            a--;
        }
        return res * rev(div) % mod;
    }

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}
