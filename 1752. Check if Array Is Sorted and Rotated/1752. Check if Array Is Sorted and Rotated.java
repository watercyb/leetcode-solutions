/*
 * Problem: 1752. Check if Array Is Sorted and Rotated
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean check(int[] nums) {
        boolean rotated = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (rotated)
                    return false;
                rotated = true;
            }
        }
        if (rotated)
            return nums[nums.length - 1] <= nums[0];
        return true;
    }
}
