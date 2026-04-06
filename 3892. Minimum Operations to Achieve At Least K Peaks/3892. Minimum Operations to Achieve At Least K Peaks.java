/*
 * Problem: 3892. Minimum Operations to Achieve At Least K Peaks
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-achieve-at-least-k-peaks/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        if (k > nums.length / 2)
            return -1;
        if (k == 0)
            return 0;
        int[] DP_1 = new int[k + 1];
        int[] DP_2 = new int[k + 1];
        int[] DP_3 = new int[k + 1];
        int[] DP_4 = new int[k + 1];
        Arrays.fill(DP_1, Integer.MAX_VALUE / 2);
        Arrays.fill(DP_2, Integer.MAX_VALUE / 2);
        Arrays.fill(DP_3, Integer.MAX_VALUE / 2);
        Arrays.fill(DP_4, Integer.MAX_VALUE / 2);
        DP_2[0] = 0;
        DP_3[1] = Math.max(Math.max(
                Math.max(nums[nums.length - 1] - nums[0] + 1, nums[1] - nums[0] + 1), 0),
                0);
        for (int i = 1; i < nums.length - 1; i++) {
            DP_2[k] = Math.min(DP_2[k], DP_1[k]);
            for (int j = Math.min(k - 1, i / 2); j >= 0; j--) {
                if (DP_2[j] < Integer.MAX_VALUE / 2) {
                    int stp = Math.max(Math.max(nums[i - 1] - nums[i] + 1, nums[i + 1] - nums[i] + 1), 0);
                    DP_1[j + 1] = Math.min(DP_1[j + 1], DP_2[j] + stp);
                }
                DP_2[j] = Math.min(DP_2[j], DP_1[j]);
            }
            DP_4[k] = Math.min(DP_4[k], DP_3[k]);
            for (int j = Math.min(k - 1, (i + 1) / 2); j >= 0; j--) {
                if (DP_4[j] < Integer.MAX_VALUE / 2) {
                    int stp = Math.max(Math.max(nums[i - 1] - nums[i] + 1, nums[i + 1] - nums[i] + 1), 0);
                    DP_3[j + 1] = Math.min(DP_3[j + 1], DP_4[j] + stp);
                }
                DP_4[j] = Math.min(DP_4[j], DP_3[j]);
            }
        }
        return Math.min(Math.min(DP_1[k], DP_2[k - 1] + Math.max(
                Math.max(nums[nums.length - 2] - nums[nums.length - 1] + 1, nums[0] - nums[nums.length - 1] + 1), 0)),
                Math.min(DP_3[k], DP_4[k]));
    }
}
