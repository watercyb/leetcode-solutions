/*
 * Problem: 3500. Minimum Cost to Divide Array Into Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minimumCost(int[] nums, int[] cost, int k) {
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        long[] DP = new long[nums.length + 1];
        long sumSuf = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sumSuf += cost[i] * k;
            long min = Long.MAX_VALUE;
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += cost[j];
                min = Math.min(sums[j] * sum + DP[j + 1] + sumSuf, min);
            }
            DP[i] = min;
        }
        return DP[0];
    }
}
