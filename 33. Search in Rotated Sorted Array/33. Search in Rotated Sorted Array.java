/*
 * Problem: 33. Search in Rotated Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        if (n < 0)
            return -1;
        int left = 0;
        int right = n;
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = 1;

        if (nums[left] > nums[right]) {
            while (left < right) {
                mid = (right - left) / 2 + left;
                
                if (nums[mid] >= nums[0])
                    left = mid + 1;
                if (nums[mid] < nums[n])
                    right = mid;

            }
            if (nums[n] >= target) {
                right = n;
            } else {
                left = 0;
                right--;
            }
        }
        
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
