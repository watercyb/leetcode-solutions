/*
 * Problem: 2461. Maximum Sum of Distinct Subarrays With Length K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        long sum = 0;
        long res = 0;
        int repeat = 0;
        for (int i = 0; i < k; i++) {
            if (counts[nums[i]]++ == 1)
                repeat++;
            sum += nums[i];
        }
        if (repeat == 0)
            res = sum;
        for (int i = k; i < nums.length; i++) {
            if (counts[nums[i]]++ == 1)
                repeat++;
            if (counts[nums[i - k]]-- == 2)
                repeat--;
            sum += nums[i] - nums[i - k];
            if (repeat == 0)
                res = Math.max(sum, res);
        }
        return res;
    }
}
