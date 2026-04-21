/*
 * Problem: 1870. Minimum Speed to Arrive on Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int h1 = (int) hour;
        int h2 = (int) (Math.ceil((hour * 1000 / 10)) % 100);
        int l = dist.length - 1;
        if (hour <= l)
            return -1;
        // dist[l] = -dist[l];
        // Arrays.sort(dist);
        int max = 10000000;
        int min = 1;

        while (min < max) {
            int mid = (max - min) / 2 + min;
            if (chk(dist, h1, h2, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;

    }

    public boolean chk(int[] dist, int h1, int h2, int speed) {
        int l = dist.length - 1;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += dist[i] / speed;
            if (dist[i] % speed > 0)
                sum++;
        }
        // System.out.println(h1 + " " + sum);
        h1 -= sum;

        return (long) h1 * 100+h2 >= (double)dist[l] * 100 / speed;

    }
}

