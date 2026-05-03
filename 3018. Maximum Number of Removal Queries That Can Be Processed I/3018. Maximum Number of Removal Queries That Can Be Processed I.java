/*
 * Problem: 3018. Maximum Number of Removal Queries That Can Be Processed I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-removal-queries-that-can-be-processed-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maximumProcessableQueries(int[] nums, int[] queries) {
        int[][] DP = new int[nums.length][nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (i > 0) {
                    if (nums[i - 1] >= queries[DP[i - 1][j]]) {
                        DP[i][j] = DP[i - 1][j] + 1;
                    } else {
                        DP[i][j] = DP[i - 1][j];
                    }
                }
                if (j < nums.length - 1) {
                    if (nums[j + 1] >= queries[DP[i][j + 1]]) {
                        DP[i][j] = Math.max(DP[i][j], DP[i][j + 1] + 1);
                    } else {
                        DP[i][j] = Math.max(DP[i][j], DP[i][j + 1]);
                    }
                }
                if (DP[i][j] == queries.length)
                    return queries.length;
            }
            if (nums[i] >= queries[DP[i][i]] && res < DP[i][i] + 1) {
                res = DP[i][i] + 1;
                if (res == queries.length)
                    return res;
            } else if (res < DP[i][i]) {
                res = DP[i][i];
            }
        }
        return res;
    }
}
