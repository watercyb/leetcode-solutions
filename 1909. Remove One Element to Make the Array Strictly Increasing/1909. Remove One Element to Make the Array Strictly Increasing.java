/*
 * Problem: 1909. Remove One Element to Make the Array Strictly Increasing
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean changed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (changed)
                    return false;
                if (i != 1 && nums[i] <= nums[i - 2])
                    nums[i] = nums[i - 1];
                changed = true;
            }
        }
        return true;
    }
}
