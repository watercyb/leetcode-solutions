/*
 * Problem: 3264. Final Array State After K Multiplication Operations I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            nums[min] *= multiplier;
        }
        return nums;
    }
}
