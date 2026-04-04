/*
 * Problem: 568. Maximum Vacation Days
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-vacation-days/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (days.length == 0 || flights.length == 0) return 0;
        int[] DP = new int[flights.length];
        DP[0] = 1;
        for (int i = 0; i < days[0].length; i++) {
            int[] DPNext = new int[flights.length];
            for (int j = 0; j < flights.length; j++) {
                DPNext[j] = DP[j];
                for (int k = 0; k < flights.length; k++) {
                    if (flights[k][j] == 1)
                        DPNext[j] = Math.max(DP[k], DPNext[j]);
                }
                if (DPNext[j] > 0)
                    DPNext[j] += days[j][i];
            }
            DP = DPNext;
        }
        int res = 0;
        for (int i = 0; i < flights.length; i++) {
            res = Math.max(DP[i], res);
        }
        return res - 1;
    }
}
