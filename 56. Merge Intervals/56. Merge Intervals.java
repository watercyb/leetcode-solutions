/*
 * Problem: 56. Merge Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-intervals/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = -1;
        int end = -1;
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (start == -1) {
                start = interval[0];
                end = interval[1];
                continue;
            }
            if (interval[0] > end) {
                res.add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            } else if (interval[1]>end) {
                end=interval[1];
            }

        }
        res.add(new int[] { start, end });
        return res.toArray(new int[res.size()][2]);
    }
}
