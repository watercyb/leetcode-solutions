/*
 * Problem: 3317. Find the Number of Possible Ways for an Event
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-number-of-possible-ways-for-an-event/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int numberOfWays(int n, int x, int y) {
        int mod = 1_000_000_007;
        long[] DP = new long[x];
        DP[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = Math.min(i + 1, x - 1); j >= 1; j--) {
                DP[j] = (DP[j] * (j + 1) + DP[j - 1]) % mod;
            }
        }
        long res = 0;
        long a = x;
        long b = 1;
        long c = y;
        for (int i = 0; i < Math.min(x, n); i++) {
            b = b * a % mod;
            res += DP[i] * b % mod * c % mod;
            a--;
            c = c * y % mod;
        }
        return (int) (res % mod);
    }
}
