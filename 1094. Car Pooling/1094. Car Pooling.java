/*
 * Problem: 1094. Car Pooling
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/car-pooling/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] line = new int[1001];
        for (int[] trip : trips) {
            line[trip[1]] += trip[0];
            line[trip[2]] -= trip[0];
        }
        for (int i = 0; i < 1000; i++) {
            capacity -= line[i];
            if (capacity < 0)
                return false;
        }
        return true;
    }
}
