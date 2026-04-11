/*
 * Problem: 1051. Height Checker
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/height-checker/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int heightChecker(int[] heights) {
        int[] counts = new int[101];
        for (int height : heights) {
            counts[height]++;
        }
        int res = 0;
        int idx = 0;
        for (int i = 0; i < heights.length; i++) {
            while (counts[idx] == 0) {
                idx++;
            }
            if (heights[i] != idx)
                res++;
            counts[idx]--;
        }
        return res;
    }
}
