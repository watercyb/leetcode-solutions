/*
 * Problem: 2282. Number of People That Can Be Seen in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-people-that-can-be-seen-in-a-grid/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int[][] seePeople(int[][] heights) {
        int[] MQ = new int[Math.max(heights.length, heights[0].length) + 1];
        int[][] res = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            int idx = 0;
            for (int j = heights[0].length - 1; j >= 0; j--) {
                while (idx > 0 && heights[i][MQ[idx - 1]] < heights[i][j]) {
                    idx--;
                    res[i][j]++;
                }
                if (idx > 0) {
                    if (heights[i][MQ[idx - 1]] == heights[i][j])
                        idx--;
                    res[i][j]++;
                }
                MQ[idx++] = j;
            }
        }
        MQ[0] = heights.length - 1;
        for (int i = 0; i < heights[0].length; i++) {
            int idx = 0;
            for (int j = heights.length - 1; j >= 0; j--) {
                while (idx > 0 && heights[MQ[idx - 1]][i] < heights[j][i]) {
                    idx--;
                    res[j][i]++;
                }
                if (idx > 0) {
                    if (heights[MQ[idx - 1]][i] == heights[j][i])
                        idx--;
                    res[j][i]++;
                }
                MQ[idx++] = j;
            }
        }
        return res;
    }
}
