/*
 * Problem: 1959. Minimum Total Space Wasted With K Resizing Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        if (k == 0) {
            int max = 0;
            int sum = 0;
            for (int num : nums) {
                max = Math.max(max, num);
                sum += num;
            }
            return max * nums.length - sum;
        }
        int[] sums = new int[nums.length + 1];
        sums[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int[][] DP = new int[nums.length][k + 1];
        for (int[] row : DP) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int stp = max * (i - j) - (sums[i + 1] - sums[j + 1]);
                for (int l = 1; l <= k; l++) {
                    DP[i][l] = Math.min(DP[i][l], DP[j][l - 1] + stp);
                }
                max = Math.max(max, nums[j]);
            }
            DP[i][0] = max * (i + 1) - (sums[i + 1] - sums[0]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, DP[DP.length - 1][i]);
        }
        return res;
    }
}
