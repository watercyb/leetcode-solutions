/*
 * Problem: 2403. Minimum Time to Kill All Monsters
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-kill-all-monsters/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long minimumTime(int[] power) {
        long[] DP = new long[1 << power.length];
        for (int i = 1; i < DP.length; i++) {
            int gain = Integer.bitCount(i);
            long min = Long.MAX_VALUE;
            for (int j = 0; j < power.length; j++) {
                if ((i & (1 << j)) != 0)
                    min = Math.min(min, DP[i - (1 << j)] + (power[j] + gain - 1) / gain);
            }
            DP[i] = min;
        }
        return DP[DP.length - 1];
    }
}
