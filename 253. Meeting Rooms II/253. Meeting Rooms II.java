/*
 * Problem: 253. Meeting Rooms II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/meeting-rooms-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(interval[1], max);
        }
        int[] arr = new int[max + 1];
        for (int[] interval : intervals) {
            arr[interval[0]]++;
            arr[interval[1]]--;
        }
        int count = 0;
        int res = 0;
        for (int num : arr) {
            count += num;
            res = Math.max(count, res);
        }
        return res;
    }
}
