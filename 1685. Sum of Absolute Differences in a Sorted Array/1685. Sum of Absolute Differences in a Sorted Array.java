/*
 * Problem: 1685. Sum of Absolute Differences in a Sorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int af=0;
        for (int i=0;i<n;i++) {
            af+=nums[i];
        }
        int[] res=new int[n];
        for (int i=0;i<n;i++) {
            res[i]=af-(n-2*i)*nums[i];
            af-=2*nums[i];
        }
        return res;
        
    }
}
