/*
 * Problem: 540. Single Element in a Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] != nums[mid ^ 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
