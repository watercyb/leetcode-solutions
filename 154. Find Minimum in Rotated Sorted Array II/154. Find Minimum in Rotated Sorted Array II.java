/*
 * Problem: 154. Find Minimum in Rotated Sorted Array II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        
        while (left<right) {
            int mid=(right-left)/2+left;
            if (nums[mid]<nums[right]){
                right=mid;
                continue;
            } 
            if (nums[mid]==nums[right]){
                right--;
                continue;
            }
            if (nums[mid]>nums[right]){
                left=mid+1;
                continue;
            }
            
        }
        
        return nums[left];
        
    }
}
