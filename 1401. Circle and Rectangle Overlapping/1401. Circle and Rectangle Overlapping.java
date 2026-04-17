/*
 * Problem: 1401. Circle and Rectangle Overlapping
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/circle-and-rectangle-overlapping/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int r2 = radius * radius;
        int minX = Math.min(Math.abs(x1 - x_center), Math.abs(x2 - x_center));
        int minY = Math.min(Math.abs(y1 - y_center), Math.abs(y2 - y_center));
        boolean xRange = x_center >= x1 && x_center <= x2;
        boolean xyRange = y_center >= y1 && y_center <= y2;
        return minX * minX + minY * minY <= r2 || xRange && minY <= radius || xyRange && minX <= radius
                || xRange && xyRange;
    }
}
