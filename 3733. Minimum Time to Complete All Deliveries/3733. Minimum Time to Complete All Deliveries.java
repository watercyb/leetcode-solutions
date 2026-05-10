/*
 * Problem: 3733. Minimum Time to Complete All Deliveries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-complete-all-deliveries/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minimumTime(int[] d, int[] r) {
        long lcm = (long) r[0] * r[1] / GCD(r[0], r[1]);
        long a = (long) Math
                .ceil((double) (d[0] + d[1]) / (lcm - 1) * lcm)
                - 1;
        long b = (long) Math.ceil((double) d[0] / (r[0] - 1) * r[0]) - 1;
        long c = (long) Math.ceil((double) d[1] / (r[1] - 1) * r[1]) - 1;
        return Math.max(Math.max(a, b), c);
    }

    public long GCD(long a, long b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
