/*
 * Problem: 2188. Minimum Time to Finish the Race
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-finish-the-race/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        long[] DP = new long[numLaps + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;
        for (int i = 0; i < tires.length; i++) {
            int f = tires[i][0];
            int r = tires[i][1];
            long t = f;
            long sum = f + changeTime;
            for (int j = 1; j <= numLaps && t < f + changeTime; j++) {
                DP[j] = Math.min(sum, DP[j]);
                t *= r;
                sum += t;
            }
        }
        boolean[] seens = new boolean[numLaps + 1];
        for (int i = 1; i <= numLaps / 2; i++) {
            if (!seens[i]) {
                long sum = 2 * DP[i];
                for (int j = i + i; j <= numLaps; j += i) {
                    if (DP[j] > sum) {
                        seens[j] = true;
                        DP[j] = sum;
                    }
                    sum += DP[i];
                }
            }
        }
        long res = Integer.MAX_VALUE;
        for (int i = 0; i <= numLaps; i++) {
            res = Math.min(DP[i] + DP[numLaps - i], res);
        }
        return (int) res - changeTime;
    }
}
