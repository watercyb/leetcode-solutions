/*
 * Problem: 2528. Maximize the Minimum Powered City
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-the-minimum-powered-city/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long[] powers = new long[stations.length + 1];
        long max = 0;
        long min = Long.MAX_VALUE;
        long power = 0;
        for (int i = 0; i < stations.length; i++) {
            powers[Math.max(i - r, 0)] += stations[i];
            powers[Math.min(i + r + 1, stations.length)] -= stations[i];
        }
        for (int i = 0; i < stations.length; i++) {
            power += powers[i];
            max = Math.max(power, max);
            min = Math.min(power, min);
        }
        long left = min;
        long right = max + k + 1;
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (!chk(powers.clone(), 2 * r + 1, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public boolean chk(long[] powers, int r, int k, long mid) {
        long power = 0;
        for (int i = 0; i < powers.length - 1; i++) {
            power += powers[i];
            if (power >= mid)
                continue;
            if (power + k >= mid) {
                long diff = mid - power;
                power = mid;
                k -= diff;
                powers[Math.min(i + r, powers.length - 1)] -= diff;
            } else {
                return false;
            }
        }
        return true;
    }
}
