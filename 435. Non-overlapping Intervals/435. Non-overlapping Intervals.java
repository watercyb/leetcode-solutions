/*
 * Problem: 435. Non-overlapping Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/non-overlapping-intervals/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int res=-1;
        int lastPoint=intervals[0][1];
        for (int i=0;i<intervals.length;i++) {
            if (intervals[i][0]<lastPoint) {
                res++;
            } else {
                lastPoint=intervals[i][1];
            }
        }
        return res;
    }
}
