/*
 * Problem: 1235. Maximum Profit in Job Scheduling
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][];
        for (int i = 0; i < startTime.length; i++) {
            arr[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int[][] DP = new int[arr.length + 1][2];
        int idx = 1;
        int prv = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] != prv) {
                DP[idx][0] = arr[i][1];
                DP[idx][1] = DP[idx - 1][1];
                idx++;
                prv = arr[i][1];
            }
            DP[idx - 1][1] = Math.max(DP[binarySearch(DP, arr[i][0], idx)][1] + arr[i][2], DP[idx - 1][1]);
        }
        return DP[idx - 1][1];
    }

    public int binarySearch(int[][] DP, int i, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid][0] > i) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
