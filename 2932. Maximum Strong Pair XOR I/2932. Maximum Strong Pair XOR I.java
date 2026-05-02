/*
 * Problem: 2932. Maximum Strong Pair XOR I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-strong-pair-xor-i/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j])){
                    max=Math.max(nums[i]^nums[j],max);
                }
            }
        }
        return max;
    }
}
