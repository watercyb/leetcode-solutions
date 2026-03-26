/*
 * Problem: 162. Find Peak Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-peak-element/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 2] < nums[nums.length - 1])
            return nums.length - 1;

        int left = 1;
        int right = nums.length - 2;
        if (left == right)
            return left;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            if (nums[mid] < nums[mid + 1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
        
    }
}
