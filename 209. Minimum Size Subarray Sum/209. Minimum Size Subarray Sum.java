/*
 * Problem: 209. Minimum Size Subarray Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=nums.length+1;
        int sum=0;
        int j=0;
        for (int i=0;i<nums.length;i++) {
            while (sum<target) {
                if (j==nums.length) {
                    if (min==nums.length+1) min=0;
                    return min;
                }
                sum+=nums[j];
                j++;           
            }

            if (j-i<min) min=j-i;
            sum-=nums[i];
        }
        return min;

    }

}
