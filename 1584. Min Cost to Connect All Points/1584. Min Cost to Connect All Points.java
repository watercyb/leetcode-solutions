/*
 * Problem: 1584. Min Cost to Connect All Points
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/min-cost-to-connect-all-points/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] seen = new boolean[points.length];
        int[] minDists = new int[points.length];
        Arrays.fill(minDists, Integer.MAX_VALUE);
        minDists[0] = 0;
        int res = 0;
        int i = 0;
        for (int j = 0; j < points.length; j++) {
            seen[i] = true;
            int min = Integer.MAX_VALUE;
            int next = -1;
            for (int k = 0; k < points.length; k++) {
                if (seen[k])
                    continue;
                minDists[k] = Math.min(Math.abs(points[i][0] - points[k][0]) + Math.abs(points[i][1] - points[k][1]),
                        minDists[k]);
                if (minDists[k] < min) {
                    min = minDists[k];
                    next = k;
                }
            }
            i = next;
        }
        for (int dist : minDists) {
            res += dist;
        }
        return res;
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
