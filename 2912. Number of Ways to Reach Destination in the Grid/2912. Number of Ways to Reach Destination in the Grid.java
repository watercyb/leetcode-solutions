/*
 * Problem: 2912. Number of Ways to Reach Destination in the Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-reach-destination-in-the-grid/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int numberOfWays(int n, int m, int k, int[] source, int[] dest) {
        int mod = 1_000_000_007;
        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        if (source[0] != dest[0] && source[1] != dest[1]) {
            a = 1;
        } else if (source[0] == dest[0] && source[1] == dest[1]) {
            d = 1;
        } else if (source[0] == dest[0]) {
            b = 1;
        } else {
            c = 1;
        }
        for (int i = 0; i < k; i++) {
            long nextA = (a * (n - 2 + m - 2) + b * (n - 1) + c * (m - 1)) % mod;
            long nextB = (a + b * (m - 2) + d * (m - 1)) % mod;
            long nextC = (a + c * (n - 2) + d * (n - 1)) % mod;
            long nextD = (b + c) % mod;
            a = nextA;
            b = nextB;
            c = nextC;
            d = nextD;
        }
        return (int) d;
    }
}
