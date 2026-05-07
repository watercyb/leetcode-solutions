/*
 * Problem: 3487. Maximum Unique Subarray Sum After Deletion
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxSum(int[] nums) {
        boolean[] seens = new boolean[101];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (nums[i] > 0 && !seens[nums[i]]) {
                seens[nums[i]] = true;
                sum += nums[i];
            }
        }
        if (sum == 0)
            return max;
        return sum;
    }
}
