/*
 * Problem: 2742. Painting the Walls
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/painting-the-walls/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int[] DP = new int[cost.length + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[cost.length] = 0;
        for (int i = 0; i < cost.length; i++) {
            for (int j = 1; j <= cost.length; j++) {
                int t = time[i] + 1;
                if (DP[j] != Integer.MAX_VALUE) {
                    int idx = Math.max(0, j - t);
                    DP[idx] = Math.min(DP[j] + cost[i], DP[idx]);
                }
            }
        }
        return DP[0];
    }
}
