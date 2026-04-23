/*
 * Problem: 2079. Watering Plants
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/watering-plants/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int beginning = 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < plants.length; i++) {
            sum += plants[i];
            if (sum > capacity) {
                res += beginning + i;
                sum = plants[i];
                beginning = i;
            }
        }
        res += beginning + plants.length;
        return res;
    }
}
