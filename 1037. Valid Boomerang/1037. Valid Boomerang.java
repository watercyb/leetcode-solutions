/*
 * Problem: 1037. Valid Boomerang
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-boomerang/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public boolean isBoomerang(int[][] points) {
        return(points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) !=(points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }
}
