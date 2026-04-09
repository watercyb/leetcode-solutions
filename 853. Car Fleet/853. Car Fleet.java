/*
 * Problem: 853. Car Fleet
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/car-fleet/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int max = 0;
        for (int p : position) {
            max = Math.max(p, max);
        }
        float[] times = new float[max + 1];
        for (int i = 0; i < position.length; i++) {
            times[position[i]] = (float) (target - position[i]) / speed[i];
        }
        double prevTime = 0;
        int res = 0;
        for (int i = max; i >= 0; i--) {
            if (times[i] > prevTime) {
                res++;
                prevTime = times[i];
            }
        }
        return res;
    }
}
