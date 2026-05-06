/*
 * Problem: 3381. Maximum Subarray Sum With Length Divisible by K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] sums = new long[k];
        Arrays.fill(sums, Long.MAX_VALUE / 2);
        sums[k - 1] = 0;
        long sum = 0;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int idx = i % k;
            sum += nums[i];
            res = Math.max(res, sum - sums[idx]);
            sums[idx] = Math.min(sums[idx], sum);
        }
        return res;
    }
}
