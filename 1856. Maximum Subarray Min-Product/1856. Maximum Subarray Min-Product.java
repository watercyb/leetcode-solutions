/*
 * Problem: 1856. Maximum Subarray Min-Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-subarray-min-product/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxSumMinProduct(int[] nums) {
        int[] MQ = new int[nums.length + 1];
        MQ[0] = -1;
        int idx = 1;
        long[] sums = new long[nums.length + 1];
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 1 && nums[MQ[idx - 1]] >= nums[i]) {
                idx--;
                res = Math.max((sums[i] - sums[MQ[idx - 1] + 1]) * nums[MQ[idx]], res);
            }
            MQ[idx++] = i;
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = idx - 1; i >= 1; i--) {
            res = Math.max((sums[nums.length] - sums[MQ[i - 1] + 1]) * nums[MQ[i]], res);
        }
        return (int) (res % 1_000_000_007);
    }
}
