/*
 * Problem: 1184. Distance Between Bus Stops
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/distance-between-bus-stops/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(getDist(distance, start, destination), getDist(distance, destination, start));
    }

    public int getDist(int[] distance, int start, int destination) {
        int res = 0;
        while (start != destination) {
            res += distance[start];
            start = (start + 1) % distance.length;
        }
        return res;
    }
}
