/*
 * Problem: 2919. Minimum Increment Operations to Make Array Beautiful
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        long DP1 = Math.max(k - nums[0], 0);
        long DP2 = Math.max(k - nums[1], 0);
        long DP3 = Math.max(k - nums[2], 0);
        for (int i = 3; i < nums.length; i++) {
            long min = Math.min(Math.min(DP1, DP2), DP3);
            DP1 = DP2;
            DP2 = DP3;
            DP3 = min + Math.max(k - nums[i], 0);
        }
        return Math.min(Math.min(DP1, DP2), DP3);
    }
}
