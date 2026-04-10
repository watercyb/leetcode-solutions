/*
 * Problem: 983. Minimum Cost For Tickets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-for-tickets/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] DP = new int[days[days.length - 1] + 30];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;
        int idx = 0;
        for (int i = 0; i < days.length; i++) {
            while (days[i] - 1 > idx) {
                DP[idx + 1] = Math.min(DP[idx], DP[idx + 1]);
                idx++;
            }
            DP[idx + 1] = Math.min(DP[idx] + costs[0], DP[idx + 1]);
            DP[idx + 7] = Math.min(DP[idx] + costs[1], DP[idx + 7]);
            DP[idx + 30] = Math.min(DP[idx] + costs[2], DP[idx + 30]);
            idx++;
        }
        int res = DP[idx];
        for (int i = idx + 1; i < idx + 30; i++) {
            res = Math.min(DP[i], res);
        }
        return res;
    }
}
