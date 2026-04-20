/*
 * Problem: 1779. Find Nearest Point That Has the Same X or Y Coordinate
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dist = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x) {
                int distTemp = Math.abs(points[i][1] - y);
                if (distTemp < dist) {
                    dist = distTemp;
                    res = i;
                }
            } else if (points[i][1] == y) {
                int distTemp = Math.abs(points[i][0] - x);
                if (distTemp < dist) {
                    dist = distTemp;
                    res = i;
                }
            }
        }
        return res;
    }
}
