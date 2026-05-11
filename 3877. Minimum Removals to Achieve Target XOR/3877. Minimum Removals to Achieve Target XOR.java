/*
 * Problem: 3877. Minimum Removals to Achieve Target XOR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int minRemovals(int[] nums, int target) {
        int max = Math.max(target, 1);
        for (int num : nums) {
            max = Math.max(max, num);
        }
        max *= 2;
        int[] DP = new int[max * 2];
        for (int num : nums) {
            int[] DPNext = DP.clone();
            for (int i = 0; i < max; i++) {
                if (DP[i] > 0)
                    DPNext[i ^ num] = Math.max(DPNext[i ^ num], DP[i] + 1);
            }
            DPNext[num] = Math.max(DPNext[num], 1);
            DP = DPNext;
        }
        if (DP[target] == 0) {
            if (target == 0)
                return nums.length;
            return -1;
        }
        return nums.length - DP[target];
    }
}
