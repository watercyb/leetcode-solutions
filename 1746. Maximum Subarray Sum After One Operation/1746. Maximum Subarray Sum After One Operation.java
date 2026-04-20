/*
 * Problem: 1746. Maximum Subarray Sum After One Operation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int[] left = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            left[i] = max;
            max += nums[i];
            if (max < 0)
                max = 0;
        }
        int[] right = new int[nums.length];
        max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = max;
            max += nums[i];
            if (max < 0)
                max = 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(left[i] + right[i] + nums[i] * nums[i], res);
        }
        return res;
    }
}
