/*
 * Problem: 3439. Reschedule Meetings for Maximum Free Time I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] arr = new int[startTime.length + 1];
        int prv = 0;
        for (int i = 0; i < startTime.length; i++) {
            arr[i] = startTime[i] - prv;
            prv = endTime[i];
        }
        arr[startTime.length] = eventTime - prv;
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += arr[i];
        }
        int res = sum;
        for (int i = k + 1; i < arr.length; i++) {
            sum += arr[i] - arr[i - k - 1];
            res = Math.max(sum, res);
        }
        return res;
    }
}
