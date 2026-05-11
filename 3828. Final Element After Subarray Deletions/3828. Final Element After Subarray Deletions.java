/*
 * Problem: 3828. Final Element After Subarray Deletions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/final-element-after-subarray-deletions/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int finalElement(int[] nums) {
        return Math.max(nums[0], nums[nums.length - 1]);
    }
}
