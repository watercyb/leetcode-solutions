/*
 * Problem: 2340. Minimum Adjacent Swaps to Make a Valid Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minimumSwaps(int[] nums) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums[max]) {
                max = i;
            } else if (nums[i] < nums[min]) {
                min = i;
            }
        }
        return nums.length - 1 - max + min - (min > max ? 1 : 0);
    }
}
