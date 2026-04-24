/*
 * Problem: 2187. Minimum Time to Complete Trips
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-complete-trips/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // Arrays.sort(time);
        long l = 10000001;
        long r = 0;
        for (int t : time) {
            if (t < l)
                l = t;
        }
        r = l * totalTrips;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(time, totalTrips, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] time, int totalTrips, long mid) {
        for (int t : time) {
            totalTrips -= mid / t;
            if (totalTrips <= 0)
                return true;
        }
        return false;
    }
}
