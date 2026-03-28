/*
 * Problem: 238. Product of Array Except Self
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int pro=1;
        for (int i=0;i<nums.length;i++) {
            res[i]=pro;
            pro*=nums[i];
        }
        pro=1;
        for (int i=nums.length-1;i>=0;i--) {
            res[i]*=pro;
            pro*=nums[i];
        }
        return res;
        
    }
}
