/*
 * Problem: 1269. Number of Ways to Stay in the Same Place After Some Steps
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = 1_000_000_007;
        arrLen = Math.min(arrLen, steps / 2 + 1);
        long[] DP = new long[arrLen + 2];
        long[] DPNext = new long[arrLen + 2];
        DP[1] = 1;
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 1; j <= arrLen; j++) {
                DPNext[j] = (DP[j - 1] + DP[j] + DP[j + 1]) % mod;
            }
            long[] tmp = DP;
            DP = DPNext;
            DPNext = tmp;
        }
        return (int)DP[1];
    }
}
