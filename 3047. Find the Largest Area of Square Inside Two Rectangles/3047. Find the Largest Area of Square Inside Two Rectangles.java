/*
 * Problem: 3047. Find the Largest Area of Square Inside Two Rectangles
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int res = 0;
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = 0; j < i; j++) {
                res = Math.max(res, Math.min(
                        Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]),
                        Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1])));
            }
        }
        return (long) res * res;
    }
}
