/*
 * Problem: 1259. Handshakes That Don't Cross
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/handshakes-that-dont-cross/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int numberOfWays(int numPeople) {
        int mod = 1_000_000_007;
        long[] DP = new long[numPeople / 2 + 1];
        DP[0] = 1;
        for (int i = 1; i < DP.length; i++) {
            long tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp = (tmp + DP[j] * DP[i - j - 1]) % mod;
            }
            DP[i] = tmp;
        }
        return (int) DP[numPeople / 2];
    }
}
