/*
 * Problem: 815. Bus Routes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/bus-routes/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] route : routes) {
            for (int in : route) {
                max = Math.max(in, max);
                min = Math.min(in, min);
            }
        }
        if (source > max || source < min || target > max || target < min)
            return -1;
        int[] dists = new int[max - min + 1];
        Arrays.fill(dists, Integer.MAX_VALUE / 2);
        dists[source - min] = 0;
        for (boolean changed = true; changed;) {
            changed = false;
            for (int[] route : routes) {
                int tmp = Integer.MAX_VALUE;
                for (int in : route) {
                    tmp = Math.min(dists[in - min], tmp);
                }
                tmp++;
                for (int in : route) {
                    if (dists[in - min] > tmp) {
                        dists[in - min] = tmp;
                        changed = true;
                    }
                }
            }
        }
        if (dists[target - min] == Integer.MAX_VALUE / 2)
            return -1;
        return dists[target - min];
    }
}
