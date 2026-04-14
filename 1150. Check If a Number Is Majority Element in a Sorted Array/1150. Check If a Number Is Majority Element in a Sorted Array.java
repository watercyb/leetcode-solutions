/*
 * Problem: 1150. Check If a Number Is Majority Element in a Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (nums[l] == target && l + nums.length / 2 < nums.length && nums[l + nums.length / 2] == target);
    }
}
