/*
 * Problem: 494. Target Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/target-sum/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target % 2 == 1 || target < 0 || target > 2000)
            return 0;
        target /= 2;
        int[] DP = new int[1001];
        DP[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1000 - nums[i]; j >= 0; j--) {
                DP[j + nums[i]] += DP[j];
            }
        }
        return DP[target];
    }
}
