/*
 * Problem: 84. Largest Rectangle in Histogram
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] MQ = new int[heights.length + 1];
        int idx = -1;
        int res = 0;
        int tmp = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (i < heights.length) {
                tmp = heights[i];
            } else {
                tmp = 0;
            }
            if (idx != -1) {
                int w = MQ[idx];
                while (idx >= 0 && heights[MQ[idx]] > tmp) {
                    int h = heights[MQ[idx]];
                    if (idx == 0) {
                        res = Math.max(h * (w + 1), res);
                    } else {
                        res = Math.max(h * (w - MQ[idx - 1]), res);
                    }
                    idx--;
                }
            }
            idx++;
            MQ[idx] = i;
        }
        return res;
    }
}
