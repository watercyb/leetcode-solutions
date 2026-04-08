/*
 * Problem: 774. Minimize Max Distance to Gas Station
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-max-distance-to-gas-station/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double l = (double) (stations[stations.length - 1] - stations[0]) / (stations.length + k - 1);
        double r = stations[stations.length - 1] - stations[0];
        while (r - l > 0.000001) {
            double mid = (l + r) / 2;
            if (chk(stations, k, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public boolean chk(int[] stations, int k, double mid) {
        for (int i = 1; i < stations.length && k >= 0; i++) {
            k -= (int) ((stations[i] - stations[i - 1]) / mid);
        }
        return k >= 0;
    }
}
