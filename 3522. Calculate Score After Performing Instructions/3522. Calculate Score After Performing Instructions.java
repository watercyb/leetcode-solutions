/*
 * Problem: 3522. Calculate Score After Performing Instructions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/calculate-score-after-performing-instructions/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long res = 0;
        int idx = 0;
        while (idx >= 0 && idx < instructions.length && values[idx] != Integer.MIN_VALUE) {
            int val = values[idx];
            values[idx] = Integer.MIN_VALUE;
            if (instructions[idx].charAt(0) == 'a') {
                res += val;
                idx++;
            } else {
                idx += val;
            }
        }
        return res;
    }
}
