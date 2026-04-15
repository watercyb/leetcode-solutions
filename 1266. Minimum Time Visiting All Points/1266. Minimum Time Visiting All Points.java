/*
 * Problem: 1266. Minimum Time Visiting All Points
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-time-visiting-all-points/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] prv = points[0];
        int steps = 0;
        for (int i = 1; i < points.length; i++) {
            steps += Math.max(Math.abs(prv[0] - points[i][0]), Math.abs(prv[1] - points[i][1]));
            prv[0] = points[i][0];
            prv[1] = points[i][1];
        }
        return steps;

    }
}
