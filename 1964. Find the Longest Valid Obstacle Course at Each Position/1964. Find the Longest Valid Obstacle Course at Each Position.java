/*
 * Problem: 1964. Find the Longest Valid Obstacle Course at Each Position
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] DP = new int[obstacles.length + 1];
        int[] res = new int[obstacles.length];
        int max = 1;
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] >= DP[max - 1]) {
                DP[max] = obstacles[i];
                res[i] = max;
                max++;
            } else {
                int l = 0;
                int r = max;
                while (l < r) {
                    int mid = (l + r) >>> 1;
                    if (obstacles[i] < DP[mid]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                DP[l] = obstacles[i];
                res[i] = l;
                max = Math.max(l + 1, max);
            }
        }
        return res;
    }
}
