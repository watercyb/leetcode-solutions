/*
 * Problem: 57. Insert Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/insert-interval/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        if (i < intervals.length) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            while (i < intervals.length && intervals[i][1] <= newInterval[1]) {
                i++;
            }
            if (i < intervals.length) {
                if (newInterval[1] >= intervals[i][0]) {
                    newInterval[1] = intervals[i][1];
                    i++;
                }
            }
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
