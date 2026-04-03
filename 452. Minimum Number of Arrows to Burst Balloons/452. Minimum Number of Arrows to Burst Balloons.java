/*
 * Problem: 452. Minimum Number of Arrows to Burst Balloons
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int res=1;
        int lastPoint=points[0][1];
        for (int i=0;i<points.length;i++) {
            if (points[i][0]>lastPoint) {
                res++;
                lastPoint=points[i][1];
            }
        }
        return res;

    }

}
