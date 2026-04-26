/*
 * Problem: 2398. Maximum Number of Robots Within Budget
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-robots-within-budget/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int j = 0;
        long sum = 0;
        int[] MQ = new int[chargeTimes.length];
        int l = 0;
        int r = 0;
        int res = 0;
        for (int i = 0; i < chargeTimes.length && chargeTimes.length - j > res; i++) {
            while (r > l && chargeTimes[i] >= chargeTimes[MQ[r - 1]]) {
                r--;
            }
            MQ[r++] = i;
            sum += runningCosts[i];
            while (i >= j && sum * (i - j + 1) + chargeTimes[MQ[l]] > budget) {
                sum -= runningCosts[j];
                j++;
                while (l < r && MQ[l] < j) {
                    l++;
                }
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
