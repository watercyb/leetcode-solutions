/*
 * Problem: 252. Meeting Rooms
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/meeting-rooms/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        int[] counts = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            if (counts[intervals[i][0]] > 0)
                return false;
            counts[intervals[i][0]] = intervals[i][1];
        }
        int prv = -1;
        for (int i = 0; i <= max; i++) {
            if (counts[i] == 0)
                continue;
            if (prv > i)
                return false;
            prv = counts[i];
        }
        return true;
    }
}
