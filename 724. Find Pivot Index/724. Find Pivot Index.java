/*
 * Problem: 724. Find Pivot Index
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-pivot-index/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int l=nums.length;
        int[] sum=new int[l+1];
        for (int i=0;i<l;i++) {
            sum[i+1]=sum[i]+nums[i];
        }
        for (int i=1;i<=l;i++) {
            if (sum[l]-sum[i]==sum[i-1]) return i-1;
        }
        return -1;
    }
        
}
