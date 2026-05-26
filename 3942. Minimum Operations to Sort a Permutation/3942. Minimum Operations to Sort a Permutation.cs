/*
 * Problem: 3942. Minimum Operations to Sort a Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
 * Language: csharp
 * Date: 2026-05-26
 */

public class Solution {
    public int MinOperations(int[] nums) {
        int idx=0;
        for (int i=1;i<nums.Length;i++) {
            if (nums[i]==0) idx=i;
            if (Math.Abs(nums[i]-nums[i-1])!=1&&Math.Abs(nums[i]-nums[i-1])!=nums.Length-1) return -1;
        }
        if (nums[(idx-1+nums.Length)%nums.Length]==nums.Length-1) {
            return Math.Min(idx,nums.Length-idx+2);
        } else {
            return Math.Min(idx+2,nums.Length-idx);
        }
    }
}
