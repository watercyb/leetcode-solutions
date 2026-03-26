/*
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int findMin(int[] nums) {
        if (nums[0]<=nums[nums.length-1]) return nums[0];
        int left=0;
        int right=nums.length-1;
        
        while (left<right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[nums.length - 1])
                right = mid;
            if (nums[mid] >= nums[0])
                left = mid + 1;
        }
        
        return nums[left];
        
        
    }
}
