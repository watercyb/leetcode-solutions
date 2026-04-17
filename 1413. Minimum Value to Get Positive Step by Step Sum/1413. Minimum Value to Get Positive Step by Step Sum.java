/*
 * Problem: 1413. Minimum Value to Get Positive Step by Step Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int minStartValue(int[] nums) {
        int res = -1;
        int sum = -1;
        for (int num : nums) {
            sum += num;
            res = Math.min(sum, res);
        }
        return -res;
    }
}
