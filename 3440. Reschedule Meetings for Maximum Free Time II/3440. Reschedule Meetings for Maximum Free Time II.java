/*
 * Problem: 3440. Reschedule Meetings for Maximum Free Time II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int prv = 0;
        int max = 0;
        int[] leftMax = new int[startTime.length];
        int[] lefts = new int[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            leftMax[i] = max;
            lefts[i] = startTime[i] - prv;
            max = Math.max(lefts[i], max);
            prv = endTime[i];
        }
        prv = eventTime;
        max = 0;
        int res = 0;
        for (int i = startTime.length - 1; i >= 0; i--) {
            int l = lefts[i];
            int r = prv - endTime[i];
            int len = endTime[i] - startTime[i];
            if (leftMax[i] >= len || max >= len) {
                res = Math.max(l + r + len, res);
            } else {
                res = Math.max(l + r, res);
            }
            max = Math.max(r, max);
            prv = startTime[i];
        }
        return res;
    }
}
