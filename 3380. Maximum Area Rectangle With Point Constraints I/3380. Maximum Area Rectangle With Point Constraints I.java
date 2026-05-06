/*
 * Problem: 3380. Maximum Area Rectangle With Point Constraints I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxRectangleArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int res = -1;
        for (int i = 0; i < points.length - 3; i++) {
            if (points[i][1] != points[i + 1][1])
                continue;
            int x1 = points[i][0];
            int x2 = points[i + 1][0];
            for (int j = i + 2; j < points.length - 1; j++) {
                if (points[j][1] == points[j + 1][1] && points[j][0] == x1 && points[j + 1][0] == x2) {
                    res = Math.max((x2 - x1) * (points[j][1] - points[i][1]), res);
                    break;
                }
                if (points[j][0] >= x1 && points[j][0] <= x2)
                    break;
            }
        }
        return res;
    }
}
