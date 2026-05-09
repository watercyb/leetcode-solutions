/*
 * Problem: 3648. Minimum Sensors to Cover Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-sensors-to-cover-grid/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minSensors(int n, int m, int k) {
        int r = 2 * k + 1;
        return (n + r - 1) / r * ((m + r - 1) / r);
    }
}
