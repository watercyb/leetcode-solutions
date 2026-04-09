/*
 * Problem: 812. Largest Triangle Area
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-triangle-area/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    res = Math.max(getArea(points[i], points[j], points[k]), res);
                }
            }
        }
        return res / 2;
    }

    public int getArea(int[] a, int[] b, int[] c) {
        return Math.abs(a[0] * (b[1] - c[1]) + c[0] * (a[1] - b[1]) + b[0] * (c[1] - a[1]));
    }
}
