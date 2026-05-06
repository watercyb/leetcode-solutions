/*
 * Problem: 3323. Minimize Connected Groups by Inserting Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-connected-groups-by-inserting-interval/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minConnectedGroups(int[][] intervals, int k) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int idx = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                intervals[idx++] = new int[] { left, right };
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        intervals[idx++] = new int[] { left, right };
        if (idx == 1)
            return 1;
        int j = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < idx; i++) {
            while (j < idx && intervals[j][0] - intervals[i][1] <= k) {
                j++;
            }
            res = Math.min(res, i + idx - j);
        }
        return res + 1;
    }
}
