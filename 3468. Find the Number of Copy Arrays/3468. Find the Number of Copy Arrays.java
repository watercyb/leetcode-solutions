/*
 * Problem: 3468. Find the Number of Copy Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-number-of-copy-arrays/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int l = bounds[0][0];
        int r = bounds[0][1];
        for (int i = 1; i < original.length && l <= r; i++) {
            int diff = original[i] - original[i - 1];
            l += diff;
            r += diff;
            l = Math.max(l, bounds[i][0]);
            r = Math.min(r, bounds[i][1]);
        }
        return Math.max(r - l + 1, 0);
    }
}
