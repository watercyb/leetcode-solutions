/*
 * Problem: 3202. Find the Maximum Length of Valid Subsequence II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] DP = new int[nums.length][k];
        int res = 0;
        nums[0] %= k;
        for (int i = 1; i < nums.length; i++) {
            nums[i] %= k;
            for (int j = i - 1; j >= 0; j--) {
                int mod = (nums[i] + nums[j]) % k;
                DP[i][mod] = Math.max(DP[j][mod] + 1, DP[i][mod]);
                res = Math.max(DP[i][mod], res);
                if (nums[i] == nums[j])
                    break;
            }
        }
        return res + 1;
    }
}
