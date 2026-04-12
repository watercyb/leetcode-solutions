/*
 * Problem: 1060. Missing Element in Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/missing-element-in-sorted-array/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int missingElement(int[] nums, int k) {
        int diff = nums[nums.length - 1] - nums[0] - nums.length + 1 - k;
        if (diff < 0)
            return nums[nums.length - 1] - diff;
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] - nums[0] > mid + k - 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[0] + l - 1 + k;
    }
}
