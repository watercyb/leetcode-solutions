/*
 * Problem: 1944. Number of Visible People in a Queue
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] MQ = new int[heights.length];
        int idx = -1;
        int[] res = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            res[i] = 1;
            while (idx >= 0 && MQ[idx] <= heights[i]) {
                idx--;
                res[i]++;
            }
            if (idx == -1)
                res[i]--;
            MQ[++idx] = heights[i];
        }
        return res;
    }
}
