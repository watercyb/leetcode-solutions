/*
 * Problem: 3229. Minimum Operations to Make Array Equal to Target
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal-to-target/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long res = 0;
        int prv = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.max(nums[i] - target[i] - prv, 0);
            prv = nums[i] - target[i];
        }
        if (prv < 0)
            res += -prv;
        return res;
    }
}
