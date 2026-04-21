/*
 * Problem: 1863. Sum of All Subset XOR Totals
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int subsetXORSum(int[] nums) {
        int res=0;
        for (int num:nums) {
            res|=num;
        }
        return res<<(nums.length-1);
    }
}
