/*
 * Problem: 495. Teemo Attacking
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/teemo-attacking/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1]>duration) {
                res+=duration;
            } else {
                res+=timeSeries[i] - timeSeries[i - 1];
            }
        }
        return res + duration;
    }
}
