/*
 * Problem: 3599. Partition Array to Minimize XOR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-to-minimize-xor/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minXor(int[] nums, int k) {
        int[] DP = new int[nums.length + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;
        for (int l = 0; l < k; l++) {
            for (int i = Math.min(nums.length - k + l, nums.length - 1); i >= l; i--) {
                int xor = 0;
                DP[i + 1] = Integer.MAX_VALUE;
                for (int j = i; j >= l; j--) {
                    xor ^= nums[j];
                    DP[i + 1] = Math.min(Math.max(DP[j], xor), DP[i + 1]);
                }
            }
        }
        return DP[DP.length - 1];
    }
}
