/*
 * Problem: 2126. Destroying Asteroids
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/destroying-asteroids/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int max = 0;
        for (int i = 0; i < asteroids.length; i++) {
            max = Math.max(asteroids[i], max);
        }
        int[] counts = new int[max + 1];
        for (int i = 0; i < asteroids.length; i++) {
            counts[asteroids[i]]++;
        }
        long sum = mass;
        for (int i = 0; i <= max; i++) {
            if (sum < i)
                return false;
            sum += (long) i * counts[i];
        }
        return true;
    }
}
