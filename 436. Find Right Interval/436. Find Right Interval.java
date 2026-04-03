/*
 * Problem: 436. Find Right Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-right-interval/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] pairs = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            pairs[i] = new int[] { intervals[i][0], i };
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] res = new int[intervals.length];
        int l = 0;
        for (int i = 0; i < intervals.length; i++) {
            l = binarySearch(pairs, intervals[i][1]);
            if (l == intervals.length) {
                res[i] = -1;
            } else {
                res[i] = pairs[l][1];
            }
        }
        return res;
    }

    public int binarySearch(int[][] pairs, int num) {
        int l = 0;
        int r = pairs.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (pairs[mid][0] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
