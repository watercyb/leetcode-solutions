/*
 * Problem: 3818. Minimum Prefix Removal to Make Array Strictly Increasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-prefix-removal-to-make-array-strictly-increasing/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int minimumPrefixLength(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1])
                return i + 1;
        }
        return 0;
    }
}
