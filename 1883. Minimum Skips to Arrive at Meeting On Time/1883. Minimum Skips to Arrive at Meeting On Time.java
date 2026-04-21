/*
 * Problem: 1883. Minimum Skips to Arrive at Meeting On Time
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-skips-to-arrive-at-meeting-on-time/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        long[] DP = new long[dist.length];
        Arrays.fill(DP, Long.MAX_VALUE);
        DP[0] = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            long t = 1000000l * dist[i] / speed;
            for (int j = i; j >= 0; j--) {
                DP[j + 1] = Math.min(DP[j + 1], DP[j] + t);
                DP[j] = add(DP[j], t);
            }
        }
        long target = 1000000l * hoursBefore - 1000000l * dist[dist.length - 1] / speed;
        for (int i = 0; i < DP.length; i++) {
            if (DP[i] <= target)
                return i;
        }
        return -1;
    }

    public long add(long a, long b) {
        long res = a + b;
        if (res % 1000000 != 0)
            res = (res / 1000000 + 1) * 1000000l;
        return res;
    }
}
