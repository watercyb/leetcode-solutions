/*
 * Problem: 956. Tallest Billboard
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/tallest-billboard/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int tallestBillboard(int[] rods) {
        int[] DP = new int[2501];
        DP[0] = 1;
        for (int rod : rods) {
            int[] DPNext = DP.clone();
            for (int i = 0; i < DP.length; i++) {
                if (DP[i] != 0) {
                    int diff = i - rod;
                    int tall = DP[i];
                    if (diff < 0) {
                        diff = -diff;
                        tall += diff;
                    }
                    if (diff < DPNext.length && DPNext[diff] < tall)
                        DPNext[diff] = tall;
                    diff = i + rod;
                    tall = DP[i] + rod;
                    if (diff < DPNext.length && DPNext[diff] < tall)
                        DPNext[diff] = tall;
                }
            }
            DP = DPNext;
        }
        return DP[0] - 1;
    }
}
