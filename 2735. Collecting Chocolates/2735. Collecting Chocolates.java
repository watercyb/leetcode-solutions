/*
 * Problem: 2735. Collecting Chocolates
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/collecting-chocolates/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public long minCost(int[] nums, int x) {
        int[] DP = new int[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            DP[i] = nums[i];
            sum += nums[i];
        }
        long res = sum;
        for (int i = 1; i < nums.length; i++) {
            int first = Math.min(DP[DP.length - 1], DP[0]);
            sum = (long) x * i + first;
            for (int j = nums.length - 1; j > 0; j--) {
                DP[j] = Math.min(DP[j - 1], DP[j]);
                sum += DP[j];
            }
            DP[0] = first;
            res = Math.min(sum, res);
        }
        return res;
    }
}
