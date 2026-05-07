/*
 * Problem: 3473. Sum of K Subarrays With Length at Least M
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-k-subarrays-with-length-at-least-m/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxSum(int[] nums, int k, int m) {
        int[][] DP = new int[k + 1][m + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(DP[i], Integer.MIN_VALUE / 2);
        }
        DP[0][0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = k - 1; j >= 0; j--) {
                if (DP[j][m - 1] > DP[j][m])
                    DP[j][m] = DP[j][m - 1];
                DP[j][m] += nums[i];
                for (int l = m - 1; l > 0; l--) {
                    DP[j][l] = DP[j][l - 1] + nums[i];
                }
                if (DP[j][m] > DP[j + 1][0])
                    DP[j + 1][0] = DP[j][m];
            }
        }
        return DP[k][0];
    }
}
