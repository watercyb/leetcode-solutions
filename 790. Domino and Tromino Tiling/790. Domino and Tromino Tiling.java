/*
 * Problem: 790. Domino and Tromino Tiling
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/domino-and-tromino-tiling/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int numTilings(int n) {
        int mod = 1_000_000_007;
        long a = 1;
        long b = 0;
        long c = 0;
        for (int i = 0; i < n; i++) {
            long aNext = (a + c) % mod;
            long bNext = (2 * a + b) % mod;
            long cNext = (a + b) % mod;
            a = aNext;
            b = bNext;
            c = cNext;
        }
        return (int) a;
    }
}
