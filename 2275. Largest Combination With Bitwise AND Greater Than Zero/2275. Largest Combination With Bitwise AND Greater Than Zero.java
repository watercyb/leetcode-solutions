/*
 * Problem: 2275. Largest Combination With Bitwise AND Greater Than Zero
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int largestCombination(int[] candidates) {
        int lim = (int) (Math.log(10000000) / Math.log(2)) + 1;
        int[] counts = new int[lim];
        for (int candidate : candidates) {
            int i = 0;
            while (candidate > 0) {
                counts[i++] += candidate & 1;
                candidate /= 2;
            }
        }
        int res = 0;
        for (int count : counts) {
            res = Math.max(count, res);
        }
        return res;
    }
}
