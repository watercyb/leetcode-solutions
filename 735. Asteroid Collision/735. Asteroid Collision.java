/*
 * Problem: 735. Asteroid Collision
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/asteroid-collision/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] arr = new int[asteroids.length];
        int idx = 0;
        for (int asteroid : asteroids) {
            while (idx > 0 && arr[idx - 1] > 0 && asteroid < 0) {
                if (asteroid + arr[idx - 1] < 0) {
                    idx--;
                } else if (asteroid + arr[idx - 1] > 0) {
                    asteroid = 0;
                    break;
                } else {
                    idx--;
                    asteroid = 0;
                    break;
                }
            }
            if (asteroid != 0)
                arr[idx++] = asteroid;
        }
        return Arrays.copyOf(arr, idx);
    }
}
