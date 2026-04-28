/*
 * Problem: 2585. Number of Ways to Earn Points
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-earn-points/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = 1_000_000_007;
        long[] DP = new long[target + 1];
        DP[0] = 1;
        for (int i = 0; i < types.length; i++) {
            long[] DPNext = DP.clone();
            int lim = types[i][1] * (types[i][0] + 1);
            for (int j = types[i][1]; j <= target; j++) {
                if (j < lim) {
                    DPNext[j] = (DPNext[j] + DPNext[j - types[i][1]]) % mod;
                } else {
                    DPNext[j] = (DPNext[j] + DPNext[j - types[i][1]] - DP[j - lim] + mod) % mod;
                }
            }
            DP = DPNext;
        }
        return (int) DP[target];
    }
}
