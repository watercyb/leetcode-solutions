/*
 * Problem: 593. Valid Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-square/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] a = getDists(p1, p2, p3, p4);
        if (a == null)
            return false;
        double[] b = getDists(p2, p1, p3, p4);
        if (b == null || b[0] != a[0] || b[1] != a[1])
            return false;
        b = getDists(p3, p1, p2, p4);
        if (b == null || b[0] != a[0] || b[1] != a[1])
            return false;
        b = getDists(p4, p1, p2, p3);
        if (b == null || b[0] != a[0] || b[1] != a[1])
            return false;
        return true;
    }

    public double[] getDists(int[] p1, int[] p2, int[] p3, int[] p4) {
        double a = getDist(p1, p2);
        double b = getDist(p1, p3);
        double c = getDist(p1, p4);
        if (a > b && b == c) {
            return new double[] { a, b };
        } else if (b > a && a == c) {
            return new double[] { b, a };
        } else if (c > a && a == b) {
            return new double[] { c, a };
        }
        return null;
    }

    public double getDist(int[] a, int[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }
}
