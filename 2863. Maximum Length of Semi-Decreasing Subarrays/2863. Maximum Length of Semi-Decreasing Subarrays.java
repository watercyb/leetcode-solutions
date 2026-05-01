/*
 * Problem: 2863. Maximum Length of Semi-Decreasing Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int maxSubarrayLength(int[] nums) {
        int[] max = new int[nums.length];
        int idx = 1;
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max[idx - 1]])
                max[idx++] = i;
        }
        int j = nums.length - 1;
        for (int i = idx - 1; i >= 0; i--) {
            while (j >= max[i] && nums[max[i]] <= nums[j]) {
                j--;
            }
            res = Math.max(j - max[i], res);
        }
        return res + 1;
    }
}
