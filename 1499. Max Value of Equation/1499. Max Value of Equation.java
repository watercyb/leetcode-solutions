/*
 * Problem: 1499. Max Value of Equation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/max-value-of-equation/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int j = 0;
        for (int i = 0; i < points.length - 1; i++) {
            if (i >= idx) {
                max = Integer.MIN_VALUE;
                j = i + 1;
            }
            while (j < points.length && points[j][0] - points[i][0] <= k) {
                int tmp = points[j][0] + points[j][1];
                if (tmp > max) {
                    max = tmp;
                    idx = j;
                }
                j++;
            }
            if (max != Integer.MIN_VALUE)
                res = Math.max(max + points[i][1] - points[i][0], res);
        }
        return res;
    }
}
