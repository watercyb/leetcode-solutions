/*
 * Problem: 963. Minimum Area Rectangle II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-area-rectangle-ii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public double minAreaFreeRect(int[][] points) {
        HashSet<Long> HS = new HashSet<>();
        for (int[] point : points) {
            HS.add(40001l * point[0] + point[1]);
        }
        double res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int x1 = points[i][0] - points[j][0];
                int y1 = points[i][1] - points[j][1];
                for (int k = j + 1; k < points.length; k++) {
                    int x2 = points[i][0] - points[k][0];
                    int y2 = points[i][1] - points[k][1];
                    if (x1 * x2 + y1 * y2 == 0) {
                        int x = points[j][0] + points[k][0] - points[i][0];
                        int y = points[j][1] + points[k][1] - points[i][1];
                        if (HS.contains(40001l * x + y))
                            res = Math.min(Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2), res);
                    }
                }
            }
        }
        if (res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
}
