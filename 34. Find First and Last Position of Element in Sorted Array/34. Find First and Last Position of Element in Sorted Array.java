/*
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] re={-1, -1};
        if (nums.length==0) return re;
        int left=0;
        int right=nums.length-1;
        if (nums[left]==target&&nums[right]==target) return new int[] {left,right};
        if (left==right) return re;
        
        while (left<right&&nums[left]!=target) {
            int mid=(right-left)/2+left;
            if (nums[mid]>=target) right=mid;
            if (nums[mid]<target) left=mid+1;    
        }
        if (nums[left]!=target) return re;
        
        right=nums.length-1;
        if (nums[right]==target) return new int[] {left,right};
        re[0]=left;
        
        while (left<right) {
            int mid=(right-left)/2+left;
            if (nums[mid]>target) right=mid;
            if (nums[mid]<=target) left=mid+1;   
        }
        
        re[1]=right-1;
        
        return re;
        
    }
}
