/*
 * Problem: 1776. Car Fleet II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/car-fleet-ii/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double min = Integer.MAX_VALUE;
        double[] res = new double[cars.length];
        double[] positions = new double[cars.length];
        double[] speeds = new double[cars.length];
        double[] times = new double[cars.length];
        int idx = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            if (cars[i][1] <= min) {
                res[i] = -1;
                min = cars[i][1];
                positions[0] = cars[i][0];
                speeds[0] = cars[i][1];
                times[0] = 0;
                idx = 1;
            } else {
                while (idx > 0 && times[idx - 1] * cars[i][1] + cars[i][0] < positions[idx - 1]) {
                    idx--;
                }
                double t = (double) (positions[idx] - cars[i][0] - times[idx] * speeds[idx])
                        / (cars[i][1] - speeds[idx]);
                res[i] = t;
                positions[idx] = t * cars[i][1] + cars[i][0];
                times[idx] = t;
                idx++;
                positions[idx] = cars[i][0];
                speeds[idx] = cars[i][1];
                times[idx] = 0;
                idx++;
                min = Math.min(cars[i][1], min);
            }
        }
        return res;
    }
}
