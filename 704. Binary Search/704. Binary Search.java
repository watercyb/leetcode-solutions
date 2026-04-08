/*
 * Problem: 704. Binary Search
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-search/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if (nums[left]>target||nums[right]<target) return -1;
        
        while(left!=right) {
            int mid=(left+right)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]>target) right=mid-1;
            if (nums[mid]<target) left=mid+1;
        }
        
        if (nums[left]==target) return left;
        return -1;
        
    }
}
