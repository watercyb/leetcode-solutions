/*
 * Problem: 3386. Button with Longest Push Time
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/button-with-longest-push-time/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int max = events[0][1];
        int res = events[0][0];
        for (int i = 1; i < events.length; i++) {
            int t = events[i][1] - events[i - 1][1];
            if (t > max || (t == max && res > events[i][0])) {
                max = t;
                res = events[i][0];
            }
        }
        return res;
    }
}
