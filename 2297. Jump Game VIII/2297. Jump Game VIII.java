/*
 * Problem: 2297. Jump Game VIII
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game-viii/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long minCost(int[] nums, int[] costs) {
        long[] DP = new long[nums.length];
        DP[nums.length - 1] = costs[nums.length - 1];
        int max = nums[nums.length - 1];
        int min = max;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                long stp = DP[i + 1];
                if (nums[i] <= max) {
                    int idx = i + 1;
                    while (nums[i] > nums[idx]) {
                        idx++;
                    }
                    stp = Math.min(DP[idx], stp);
                }
                DP[i] = stp + costs[i];
                max = Math.max(nums[i], max);
            } else if (nums[i] <= nums[i + 1]) {
                long stp = DP[i + 1];
                if (nums[i] > min) {
                    int idx = i + 1;
                    while (nums[i] <= nums[idx]) {
                        idx++;
                    }
                    stp = Math.min(DP[idx], stp);
                }
                DP[i] = stp + costs[i];
                min = Math.min(nums[i], min);
            }
        }
        return DP[0] - costs[0];
    }
}
