/*
 * Problem: 3141. Maximum Hamming Distances
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-hamming-distances/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] maxHammingDistances(int[] nums, int m) {
        int[] DP = new int[1 << m];
        for (int num : nums) {
            DP[num] = m;
        }
        for (int i = 1 << (m - 1); i >= 1; i /= 2) {
            int[] DPNext = new int[1 << m];
            for (int j = 0; j < DP.length; j++) {
                DPNext[j ^ i] = Math.max(DP[j ^ i], DP[j] + 1);
            }
            DP = DPNext;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = DP[nums[i]] - m;
        }
        return res;
    }
}
