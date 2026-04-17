/*
 * Problem: 1453. Maximum Number of Darts Inside of a Circular Dartboard
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int numPoints(int[][] darts, int r) {
        int r2 = r * r;
        int d2 = r2 * 4;
        int res = 1;
        for (int i = 0; i < darts.length; i++) {
            for (int j = i + 1; j < darts.length; j++) {
                if (getDist(darts[i], darts[j]) > d2)
                    continue;
                double[] ori = findCircleCenters(darts[i], darts[j], r);
                res = Math.max(getCount(darts, ori[0], ori[1], r2), res);
                res = Math.max(getCount(darts, ori[2], ori[3], r2), res);
            }
        }
        return res;
    }

    public int getCount(int[][] darts, double x, double y, int r2) {
        int res = 0;
        for (int[] dart : darts) {
            if ((dart[0] - x) * (dart[0] - x) + (dart[1] - y) * (dart[1] - y) <= r2)
                res++;
        }
        return res;
    }

    public int getDist(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }

    public double[] findCircleCenters(int[] a, int[] b, int r) {
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        int xh = x2 - x1;
        int yh = y2 - y1;
        double xs = (double) (x2 + x1) / 2;
        double ys = (double) (y2 + y1) / 2;
        double d = Math.sqrt(xh * xh + yh * yh);
        double h = Math.sqrt(r * r - (double) (xh * xh + yh * yh) / 4);
        return new double[] { xs - h * yh / d, ys + h * xh / d, xs + h * yh / d, ys - h * xh / d };
    }
}
