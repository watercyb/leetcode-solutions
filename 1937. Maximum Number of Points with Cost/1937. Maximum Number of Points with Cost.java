/*
 * Problem: 1937. Maximum Number of Points with Cost
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-points-with-cost/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public long maxPoints(int[][] points) {
        long[] sum = new long[points[0].length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 1; j < points[0].length; j++) {
                sum[j] = Math.max(sum[j - 1] - 1, sum[j]);
            }
            for (int j = points[0].length - 2; j >= 0; j--) {
                sum[j] = Math.max(sum[j + 1] - 1, sum[j]);
            }
            for (int j = 0; j < points[0].length; j++) {
                sum[j] += points[i][j];
            }
        }
        long res = Long.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            res = Math.max(sum[i], res);
        }
        return res;
    }
}
