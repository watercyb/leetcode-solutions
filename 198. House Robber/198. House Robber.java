/*
 * Problem: 198. House Robber
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public int rob(int[] nums) {
        int[] moneys=new int[nums.length+1];
        moneys[1]=nums[0];
        for (int i=1;i<nums.length;i++) {
            moneys[i+1]=Math.max(moneys[i],moneys[i-1]+nums[i]);
        }
        return moneys[nums.length];
    }
}
