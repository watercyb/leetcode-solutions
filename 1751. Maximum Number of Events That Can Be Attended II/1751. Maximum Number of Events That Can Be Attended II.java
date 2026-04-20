/*
 * Problem: 1751. Maximum Number of Events That Can Be Attended II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maxValue(int[][] events, int k) {
        if (k == 1) {
            int res = 0;
            for (int[] event : events)
                res = Math.max(event[2], res);
            return res;
        }
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int[][] DP = new int[events.length + 1][k + 1];
        for (int i = 0; i < events.length; i++) {
            int left = events[i][0];
            int point = events[i][2];
            int idx = binarySearch(events, left, i + 1);
            for (int j = 0; j < Math.min(k, i + 1); j++) {
                DP[i + 1][j + 1] = Math.max(Math.max(DP[idx][j] + point, DP[i][j + 1]), DP[i + 1][j + 1]);
            }
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = Math.max(DP[events.length][i], res);
        }
        return res;
    }

    public int binarySearch(int[][] events, int i, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (events[mid][1] >= i) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
