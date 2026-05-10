/*
 * Problem: 3717. Minimum Operations to Make the Array Beautiful
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-the-array-beautiful/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minOperations(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[][] DP = new int[nums.length][2 * max];
        for (int[] row : DP) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        DP[0][nums[0]] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i - 1]; j < DP[0].length; j++) {
                int start = j >= nums[i] ? j : (int) Math.ceil((float) nums[i] / j) * j;
                for (int k = start; k < DP[0].length; k += j) {
                    DP[i][k] = Math.min(DP[i][k], DP[i - 1][j] + k - nums[i]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < DP[0].length; i++) {
            res = Math.min(res, DP[DP.length - 1][i]);
        }
        return res;
    }
}
