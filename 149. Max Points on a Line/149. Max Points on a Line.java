/*
 * Problem: 149. Max Points on a Line
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/max-points-on-a-line/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        int res = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int count = 2;
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                for (int k = j + 1; k < points.length; k++) {
                    if ((points[k][1] - points[j][1]) * x == y
                            * (points[k][0] - points[j][0]))
                        count++;
                }
                if (count > res)
                    res = count;
            }
        }
        return res;
    }
}
